<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
              <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimcontract.default_searchform.details.grouppanel2')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false">
              <row>
                  <i-col v-show="detailsModel.n_ygbh_like.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ygbh_like' :itemRules="this.rules.n_ygbh_like" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_ygbh_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ygbh_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_ygbh_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_ygbh_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_pimpersonname_like.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_pimpersonname_like' :itemRules="this.rules.n_pimpersonname_like" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_pimpersonname_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_pimpersonname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_pimpersonname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_pimpersonname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ygzt_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ygzt_eq' :itemRules="this.rules.n_ygzt_eq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_ygzt_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ygzt_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_ygzt_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_ygzt_eq.disabled"  
              tag='EhrCodeList0014' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_htbh_like.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_htbh_like' :itemRules="this.rules.n_htbh_like" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_htbh_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_htbh_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_htbh_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_htbh_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_htlx_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_htlx_eq' :itemRules="this.rules.n_htlx_eq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_htlx_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_htlx_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_htlx_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_htlx_eq.disabled"  
              tag='EhrCodeList0084' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_htzt_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_htzt_eq' :itemRules="this.rules.n_htzt_eq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_htzt_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_htzt_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_htzt_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_htzt_eq.disabled"  
              tag='EhrCodeList0030' 
              codelistType='STATIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_qsrq_gtandeq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_qsrq_gtandeq' :itemRules="this.rules.n_qsrq_gtandeq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_qsrq_gtandeq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_qsrq_gtandeq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.n_qsrq_gtandeq" :disabled="detailsModel.n_qsrq_gtandeq.disabled" style="min-width: 150px; width:100%;" @on-change="(val1, val2) => { this.data.n_qsrq_gtandeq = val1 }"></date-picker>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_jsrq_ltandeq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_jsrq_ltandeq' :itemRules="this.rules.n_jsrq_ltandeq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_jsrq_ltandeq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_jsrq_ltandeq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.n_jsrq_ltandeq" :disabled="detailsModel.n_jsrq_ltandeq.disabled" style="min-width: 150px; width:100%;" @on-change="(val1, val2) => { this.data.n_jsrq_ltandeq = val1 }"></date-picker>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_contracttype_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_contracttype_eq' :itemRules="this.rules.n_contracttype_eq" class='' :caption="$t('entities.pimcontract.default_searchform.details.n_contracttype_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_contracttype_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_contracttype_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_contracttype_eq.disabled"  
              tag='EhrCodeList0107' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          
              </row>
          </app-form-group>
          
          </i-col>
      </row>
    </i-col>
    <i-col span="4" class="search-button">
      <row v-show="Object.keys(data).length>0">
        <i-button class='search_reset'  size="default" type="primary"  @click="onSearch">{{$t('app.searchButton.search')}}</i-button>
        <i-button class='search_reset'  size="default"  @click="onReset">{{this.$t('app.searchButton.reset')}}</i-button>
      </row>
    </i-col>
  </row>
</i-form>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PimContractService from '@/service/pim-contract/pim-contract-service';
import DefaultService from './default-searchform-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class DefaultBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Default
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Default
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Default
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Default
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Default
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Default
     */
    public getControlType(): string {
        return 'SEARCHFORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Default
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {DefaultService}
     * @memberof Default
     */
    public service: DefaultService = new DefaultService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimContractService}
     * @memberof Default
     */
    public appEntityService: PimContractService = new PimContractService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Default
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Default
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof DefaultBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof DefaultBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof DefaultBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public loadAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof DefaultBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof DefaultBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof DefaultBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof DefaultBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof DefaultBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public data: any = {
        n_ygbh_like: null,
        n_pimpersonname_like: null,
        n_ygzt_eq: null,
        n_htbh_like: null,
        n_htlx_eq: null,
        n_htzt_eq: null,
        n_qsrq_gtandeq: null,
        n_jsrq_ltandeq: null,
        n_contracttype_eq: null,
    };

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public rules: any = {
        n_ygbh_like: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        n_pimpersonname_like: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        n_ygzt_eq: [
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工状态 值不能为空', trigger: 'blur' },
        ],
        n_htbh_like: [
            { type: 'string', message: '合同编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同编号 值不能为空', trigger: 'blur' },
        ],
        n_htlx_eq: [
            { type: 'string', message: '合同类别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同类别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同类别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同类别 值不能为空', trigger: 'blur' },
        ],
        n_htzt_eq: [
            { type: 'string', message: '合同状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同状态 值不能为空', trigger: 'blur' },
        ],
        n_qsrq_gtandeq: [
            { type: 'string', message: '起始日期（>=） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '起始日期（>=） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '起始日期（>=） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '起始日期（>=） 值不能为空', trigger: 'blur' },
        ],
        n_jsrq_ltandeq: [
            { type: 'string', message: '结束日期（<=） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '结束日期（<=） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '结束日期（<=） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '结束日期（<=） 值不能为空', trigger: 'blur' },
        ],
        n_contracttype_eq: [
            { type: 'string', message: '合同类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同类型 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public detailsModel: any = {
        grouppanel2: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimcontract.default_searchform', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '常规条件', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_ygbh_like: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'n_ygbh_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_pimpersonname_like: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'n_pimpersonname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ygzt_eq: new FormItemModel({ caption: '员工状态', detailType: 'FORMITEM', name: 'n_ygzt_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_htbh_like: new FormItemModel({ caption: '合同编号', detailType: 'FORMITEM', name: 'n_htbh_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_htlx_eq: new FormItemModel({ caption: '合同类别', detailType: 'FORMITEM', name: 'n_htlx_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_htzt_eq: new FormItemModel({ caption: '合同状态', detailType: 'FORMITEM', name: 'n_htzt_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_qsrq_gtandeq: new FormItemModel({ caption: '起始日期（>=）', detailType: 'FORMITEM', name: 'n_qsrq_gtandeq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_jsrq_ltandeq: new FormItemModel({ caption: '结束日期（<=）', detailType: 'FORMITEM', name: 'n_jsrq_ltandeq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_contracttype_eq: new FormItemModel({ caption: '合同类型', detailType: 'FORMITEM', name: 'n_contracttype_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 n_ygbh_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ygbh_like')
    onN_ygbh_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ygbh_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_pimpersonname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_pimpersonname_like')
    onN_pimpersonname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_pimpersonname_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ygzt_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ygzt_eq')
    onN_ygzt_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ygzt_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_htbh_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_htbh_like')
    onN_htbh_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_htbh_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_htlx_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_htlx_eq')
    onN_htlx_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_htlx_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_htzt_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_htzt_eq')
    onN_htzt_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_htzt_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_qsrq_gtandeq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_qsrq_gtandeq')
    onN_qsrq_gtandeqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_qsrq_gtandeq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_jsrq_ltandeq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_jsrq_ltandeq')
    onN_jsrq_ltandeqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_jsrq_ltandeq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_contracttype_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_contracttype_eq')
    onN_contracttype_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_contracttype_eq', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof DefaultBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof DefaultBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                











    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof DefaultBase
     */
    public formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.resetFormData({ name: name, newVal: newVal, oldVal: oldVal });
        this.formLogic({ name: name, newVal: newVal, oldVal: oldVal });
        this.dataChang.next(JSON.stringify(this.data));
    }

    /**
     * 表单加载完成
     *
     * @public
     * @param {*} [data={}]
     * @memberof DefaultBase
     */
    public onFormLoad(data: any = {}): void {
        this.setFormEnableCond(data);
        this.fillForm(data);
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @memberof DefaultBase
     */
    public fillForm(_datas: any = {}): void {
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof DefaultBase
     */
    public setFormEnableCond(data: any): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setEnableCond(data.srfuf);
        });
    }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof DefaultBase
     */
    public resetDraftFormStates(): void {
        const form: any = this.$refs.form;
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof DefaultBase
     */
    public resetValidates(): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setError('');
        });
    }

    /**
     * 填充校验结果 （后台）
     *
     * @param {any[]} fieldErrors
     * @memberof DefaultBase
     */
    public fillValidates(fieldErrors: any[]): void {
        fieldErrors.forEach((error: any) => {
            const formItem: FormItemModel = this.detailsModel[error.field];
            if (!formItem) {
                return;
            }
            this.$nextTick(() => {
                formItem.setError(error.message);
            });
        });
    }

    /**
     * 表单校验状态
     *
     * @returns {boolean} 
     * @memberof DefaultBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.searchform;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        return validatestate
    }

    /**
     * 获取全部值
     *
     * @returns {*}
     * @memberof DefaultBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof DefaultBase
     */
    public onFormItemValueChange($event: { name: string, value: any }): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !this.data.hasOwnProperty($event.name)) {
            return;
        }
        this.data[$event.name] = $event.value;
    }

    /**
     * 设置数据项值
     *
     * @param {string} name
     * @param {*} value
     * @returns {void}
     * @memberof DefaultBase
     */
    public setDataItemValue(name: string, value: any): void {
        if (!name || Object.is(name, '') || !this.data.hasOwnProperty(name)) {
            return;
        }
        if (Object.is(this.data[name], value)) {
            return;
        }
        this.data[name] = value;
    }



    /**
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public groupUIActionClick($event: any): void {
        if (!$event) {
            return;
        }
        const item:any = $event.item;
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof DefaultBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof DefaultBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('autoload', action)) {
                    this.autoLoad(data);
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('loaddraft', action)) {
                    this.loadDraft(data);
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof DefaultBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof DefaultBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if (this.dataChangEvent) {
            this.dataChangEvent.unsubscribe();
        }
    }

    /**
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof DefaultBase
     */
    public autoLoad(arg: any = {}): void {
        if (arg.srfkey && !Object.is(arg.srfkey, '')) {
            Object.assign(arg, { srfkey: arg.srfkey });
            this.load(arg);
            return;
        }
        if (arg.srfkeys && !Object.is(arg.srfkeys, '')) {
            Object.assign(arg, { srfkey: arg.srfkeys });
            this.load(arg);
            return;
        }
        this.loadDraft(arg);
    }

    /**
     * 加载
     *
     * @public
     * @param {*} [opt={}]
     * @memberof DefaultBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTGRContractGridView视图搜索表单loadAction参数未配置' });
            return;
        }
        const arg: any = { ...opt };
        Object.assign(arg,{viewparams:this.viewparams});
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.onFormLoad(data);
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }

            const { data: _data } = response;
            this.$Notice.error({ title: _data.title, desc: _data.message });
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof DefaultBase
     */
    public loadDraft(opt: any = {},mode?:string): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTGRContractGridView视图搜索表单loaddraftAction参数未配置' });
            return;
        }
        const arg: any = { ...opt } ;
        Object.assign(arg,{viewparams:this.viewparams});
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: '错误', desc: response.errorMessage });
                }
                return;
            }

            const data = response.data;
            this.resetDraftFormStates();
            this.onFormLoad(data);
            setTimeout(() => {
                const form: any = this.$refs.form;
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
            if(Object.is(mode,'RESET')){
                if (!this.formValidateStatus()) {
                    return;
                }
            }
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }

            const { data: _data } = response;
            this.$Notice.error({ title: _data.title, desc: _data.message });
        });
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof DefaultBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public onEnter($event: any): void {
        if (!this.formValidateStatus()) {
            return;
        }
        this.$emit('search', this.data);
    }

    /**
     * 搜索
     *
     * @memberof DefaultBase
     */
    public onSearch() {
        if (!this.formValidateStatus()) {
            return;
        }
        this.$emit('search', this.data);
    }

    /**
     * 重置
     *
     * @memberof DefaultBase
     */
    public onReset() {
        this.loadDraft({},'RESET');
    }
}
</script>

<style lang='less'>
@import './default-searchform.less';
</style>