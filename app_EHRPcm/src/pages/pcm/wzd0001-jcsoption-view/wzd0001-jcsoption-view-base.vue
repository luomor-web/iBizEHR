<template>
  <app-layout viewName="wzd0001jcsoptionview" viewTitle="局总部初审" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'deoptview': true, 'wzd0001-jcsoption-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
            <app-studioaction viewTitle="局总部初审" viewName="wzd0001jcsoptionview"></app-studioaction>
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
import WZD0001Service from '@/service/wzd0001/wzd0001-service';

import OptionViewEngine from '@engine/view/option-view-engine';


/**
 * 局总部初审基类
 *
 * @export
 * @class WZD0001JCSOptionViewBase
 * @extends {OptionViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class WZD0001JCSOptionViewBase extends OptionViewBase {

    /**
     * 实体服务对象
     *
     * @type {WZD0001Service}
     * @memberof WZD0001JCSOptionViewBase
     */
    public appEntityService: WZD0001Service = new WZD0001Service;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof WZD0001JCSOptionViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof WZD0001JCSOptionViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof WZD0001JCSOptionViewBase
	 */
	public viewtag: string = 'b8a34744d439abfff6ca42202a0c9d85';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof WZD0001JCSOptionViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof WZD0001JCSOptionViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof WZD0001JCSOptionViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof WZD0001JCSOptionViewBase
     */
    public model: any = {
        srfCaption: 'entities.wzd0001.views.jcsoptionview.caption',
        srfTitle: 'entities.wzd0001.views.jcsoptionview.title',
        srfSubTitle: 'entities.wzd0001.views.jcsoptionview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof WZD0001JCSOptionViewBase
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
     * @memberof WZD0001JCSOptionViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof WZD0001JCSOptionViewBase
     */
    public engine: OptionViewEngine = new OptionViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof WZD0001JCSOptionViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'wzd0001',
            majorPSDEField: 'wzd0001name',
            isLoadDefault: true,
        });
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WZD0001JCSOptionViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WZD0001JCSOptionViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WZD0001JCSOptionViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof WZD0001JCSOptionViewBase
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
     * @memberof WZD0001JCSOptionViewBase
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
     * @memberof WZD0001JCSOptionViewBase
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './wzd0001-jcsoption-view.less';
</style>