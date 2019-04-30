package com.youyijia.goodhealth.app.order.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.youyijia.goodhealth.app.jknews.QaType;
import com.youyijia.goodhealth.entity.OrderInfo;

import java.util.List;

/**
 * Created by wangqiang on 2019/4/28.
 */
public class WholeQadapter extends MultipleItemRvAdapter<OrderInfo, BaseViewHolder> {
    public WholeQadapter(@Nullable List<OrderInfo> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(OrderInfo orderInfo) {
        int size = orderInfo.getOrderItems().size();
        if (size == 1) {
            return QaType.QAONEPIC;
        } else {
            return QaType.QAMorePIC;
        }
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new QaOneOrderItemProvider());
        mProviderDelegate.registerProvider(new QaMoreOrderItemProvider());
    }
}
