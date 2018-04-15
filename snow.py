import pandas as pd
import numpy as np
import lightgbm as lgb
from sklearn.model_selection import train_test_split
from sklearn.metrics import log_loss
from sklearn import preprocessing
import warnings

warnings.filterwarnings("ignore")

import time


def timestamp_datetime(value):
    format = '%Y-%m-%d %H:%M:%S'
    value = time.localtime(value)
    dt = time.strftime(format, value)
    return dt


def base_process(data):
    lbl = preprocessing.LabelEncoder()
    print(
        '--------------------------------------------------------------item--------------------------------------------------------------')
    data['len_item_category'] = data['item_category_list'].map(lambda x: len(str(x).split(';')))
    data['len_item_property'] = data['item_property_list'].map(lambda x: len(str(x).split(';')))
    for i in range(1, 3):
        data['item_category_list' + str(i)] = lbl.fit_transform(data['item_category_list'].map(
            lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))  # item_category_list的第0列全部都一样
    for i in range(10):
        data['item_property_list' + str(i)] = lbl.fit_transform(data['item_property_list'].map(lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))
    for col in ['item_id', 'item_brand_id', 'item_city_id']:
        data[col] = lbl.fit_transform(data[col])
    print(
        '--------------------------------------------------------------user--------------------------------------------------------------')
    for col in ['user_id']:
        data[col] = lbl.fit_transform(data[col])
    print('user 0,1 feature')
    data['gender0'] = data['user_gender_id'].apply(lambda x: 1 if x == -1 else 2)
    data['age0'] = data['user_age_level'].apply(lambda x: 1 if x == 1004 | x == 1005 | x == 1006 | x == 1007  else 2)
    data['occupation0'] = data['user_occupation_id'].apply(lambda x: 1 if x == -1 | x == 2003  else 2)
    data['star0'] = data['user_star_level'].apply(lambda x: 1 if x == -1 | x == 3000 | x == 3001  else 2)
    print(
        '--------------------------------------------------------------context--------------------------------------------------------------')
    data['realtime'] = data['context_timestamp'].apply(timestamp_datetime)
    data['realtime'] = pd.to_datetime(data['realtime'])
    data['day'] = data['realtime'].dt.day
    data['hour'] = data['realtime'].dt.hour
    data['len_predict_category_property'] = data['predict_category_property'].map(lambda x: len(str(x).split(';')))
    for i in range(5):
        data['predict_category_property' + str(i)] = lbl.fit_transform(data['predict_category_property'].map(
            lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))
    print('context 0,1 feature')
    data['context_page0'] = data['context_page_id'].apply(
        lambda x: 1 if x == 4001 | x == 4002 | x == 4003 | x == 4004 | x == 4007  else 2)
    print(
        '--------------------------------------------------------------shop--------------------------------------------------------------')
    for col in ['shop_id']:
        data[col] = lbl.fit_transform(data[col])
    data['shop_score_delivery0'] = data['shop_score_delivery'].apply(lambda x: 0 if x <= 0.98 and x >= 0.96  else 1)
    return data


def map_hour(x):
    if (x>=7)&(x<=12):
        return 1
    elif (x>=13)&(x<=20):
        return 2
    else:
        return 3
def lgbCV(train, test):
    col = [c for c in train if
           c not in ['is_trade', 'item_category_list', 'item_property_list', 'predict_category_property', 'instance_id',
                     'context_id', 'realtime', 'context_timestamp']]
    # cat = ['sale_price', 'gender_star', 'user_age_level', 'item_price_level', 'item_sales_level', 'sale_collect',
    #        'price_collect', 'item_brand_id', 'user_star_level', 'item_id', 'shop_id',
    #        'item_city_id', 'context_page_id', 'gender_age', 'shop_star_level', 'item_pv_level', 'user_occupation_id',
    #        'day', 'gender_occ', 'user_gender_id']
    X = train[col]
    y = train['is_trade'].values
    X_tes = test[col]
    y_tes = test['is_trade'].values
    print('Training LGBM model...')
    lgb0 = lgb.LGBMClassifier(
        objective='binary',
        # metric='binary_error',
        num_leaves=35,
        depth=8,
        learning_rate=0.05,
        seed=2018,
        colsample_bytree=0.8,
        # min_child_samples=8,
        subsample=0.9,
        n_estimators=20000)
    lgb_model = lgb0.fit(X, y, eval_set=[(X_tes, y_tes)], early_stopping_rounds=200)
    best_iter = lgb_model.best_iteration_
    predictors = [i for i in X.columns]
    feat_imp = pd.Series(lgb_model.feature_importance(), predictors).sort_values(ascending=False)
    print(feat_imp)
    print(feat_imp.shape)
    # pred= lgb_model.predict(test[col])
    pred = lgb_model.predict_proba(test[col])[:, 1]
    test['pred'] = pred
    test['index'] = range(len(test))
    # print(test[['is_trade','pred']])
    print('误差 ', log_loss(test['is_trade'], test['pred']))
    return best_iter

def sub(train, test, best_iter):
    col = [c for c in train if
           c not in ['is_trade', 'item_category_list', 'item_property_list', 'predict_category_property', 'instance_id',
                     'context_id', 'realtime', 'context_timestamp']]
    X = train[col]
    y = train['is_trade'].values
    print('Training LGBM model...')
    lgb0 = lgb.LGBMClassifier(
        objective='binary',
        # metric='binary_error',
        num_leaves=35,
        depth=8,
        learning_rate=0.05,
        seed=2018,
        colsample_bytree=0.8,
        # min_child_samples=8,
        subsample=0.9,
        n_estimators=best_iter)
    lgb_model = lgb0.fit(X, y)
    predictors = [i for i in X.columns]
    feat_imp = pd.Series(lgb_model.feature_importance(), predictors).sort_values(ascending=False)
    print(feat_imp)
    print(feat_imp.shape)
    # pred= lgb_model.predict(test[col])
    pred = lgb_model.predict_proba(test[col])[:, 1]
    test['predicted_score'] = pred
    sub1 = test[['instance_id', 'predicted_score']]
    sub=pd.read_csv("input/test.txt", sep="\s+")
    sub=pd.merge(sub,sub1,on=['instance_id'],how='left')
    sub=sub.fillna(0)
    #sub[['instance_id', 'predicted_score']].to_csv('result/result0320.csv',index=None,sep=' ')
    sub[['instance_id', 'predicted_score']].to_csv('result/result0326.txt',sep=" ",index=False)


if __name__ == "__main__":
    train = pd.read_csv("input/train.txt", sep="\s+")
    test = pd.read_csv("input/test.txt", sep="\s+")
    data = pd.concat([train, test])
    data = data.drop_duplicates(subset='instance_id')  # 把instance id去重
    print('make feature')
    data = base_process(data)
    data=shijian(data)
    data=shop_fenduan(data)
    data = slide_cnt(data)
    data = zuhe(data)
    print('----------------------------全局统计特征---------------------------------------------------')
    data = item(data)
    data = user(data)
    data = user_item(data)
    data = user_shop(data)
    data=shop_item(data)
    "----------------------------------------------------线下----------------------------------------"
    train= data[(data['day'] >= 18) & (data['day'] <= 23)]
    test= data[(data['day'] == 24)]
    best_iter = lgbCV(train, test)
    "----------------------------------------------------线上----------------------------------------"
    train = data[data.is_trade.notnull()]
    test = data[data.is_trade.isnull()]
    sub(train, test, best_iter)
