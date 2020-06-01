<template>
  <app-layout viewName="pcmwzd0001ygszkqoptionview" viewTitle="员工设置考勤" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'deoptview': true, 'pcm-wzd0001-ygszkqoption-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
            <app-studioaction viewTitle="员工设置考勤" viewName="pcmwzd0001ygszkqoptionview"></app-studioaction>
    <card class='view-card view-no-caption' dis-hover :padding="0" :bordered="false">
        <div class="content-container">
            <view_form 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :autosave="false" 
                :viewtag="viewtag"
                :showBusyIndicator="true"
                updateAction="Update"
                removeAction="Remove"
                loaddraftAction="GetDraft"
                loadAction="Get"
                createAction="Create"
                WFSubmitAction=""
                WFStartAction=""
                style='' 
                name="form"  
                ref='form' 
                @save="form_save($event)"  
                @remove="form_remove($event)"  
                @load="form_load($event)"  
                @closeview="closeView($event)">
            </view_form>
        </div>
        <card dis-hover :bordered="false" class='footer'>
          <row style=" text-align: right ">
            <i-button type='primary' @click="onClickOk">{{ containerModel.view_okbtn.text }}</i-button>
              &nbsp;&nbsp;
            <i-button @click="onClickCancel">{{ containerModel.view_cancelbtn.text }}</i-button>
          </row>
        </card>
    </card>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, OptionViewBase } from '@/crm-core';
import PcmWzd0001Service from '@/service/pcm-wzd0001/pcm-wzd0001-service';

import OptionViewEngine from '@engine/view/option-view-engine';


/**
 * 员工设置考勤基类
 *
 * @export
 * @class PcmWzd0001YGSZKQOptionViewBase
 * @extends {OptionViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmWzd0001YGSZKQOptionViewBase extends OptionViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmWzd0001Service}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public appEntityService: PcmWzd0001Service = new PcmWzd0001Service;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmWzd0001YGSZKQOptionViewBase
	 */
	public viewtag: string = '7f5fde30882cd704aa8fdaf922c320fa';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmWzd0001YGSZKQOptionViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmWzd0001YGSZKQOptionViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmwzd0001.views.ygszkqoptionview.caption',
        srfTitle: 'entities.pcmwzd0001.views.ygszkqoptionview.title',
        srfSubTitle: 'entities.pcmwzd0001.views.ygszkqoptionview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public containerModel: any = {
        view_form: { name: 'form', type: 'FORM' },
        view_okbtn: { name: 'okbtn', type: 'button', text: '确定', disabled: true },
        view_cancelbtn: { name: 'cancelbtn', type: 'button', text: '取消', disabled: false },
        view_leftbtn: { name: 'leftbtn', type: 'button', text: '左移', disabled: true },
        view_rightbtn: { name: 'rightbtn', type: 'button', text: '右移', disabled: true },
        view_allleftbtn: { name: 'allleftbtn', type: 'button', text: '全部左移', disabled: true },
        view_allrightbtn: { name: 'allrightbtn', type: 'button', text: '全部右移', disabled: true },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public engine: OptionViewEngine = new OptionViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'pcmwzd0001',
            majorPSDEField: 'wzd0001name',
            isLoadDefault: true,
        });
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public destroyed(){
        if(this.viewDefaultUsage){
            let localStoreLength = Object.keys(localStorage);
            if(localStoreLength.length > 0){
                localStoreLength.forEach((item:string) =>{
                if(item.startsWith(this.context.srfsessionid)){
                    localStorage.removeItem(item);
                }
                })
            }
        }
    }

    /**
     * 确定
     *
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public onClickOk(): void {
        const form: any = this.$refs.form;
        if (!form) return;
        form.save().then((res:any) =>{
            if(res.status == 200){
                this.$emit('close',[res.data]);
            }
        });
    }

    /**
     * 取消
     *
     * @memberof PcmWzd0001YGSZKQOptionViewBase
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './pcm-wzd0001-ygszkqoption-view.less';
</style>