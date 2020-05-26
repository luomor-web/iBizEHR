<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.n_zzdzs_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_zzdzs_like' :itemRules="this.rules.n_zzdzs_like" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_zzdzs_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_zzdzs_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_zzdzs_like" :data="data" :itemParam="{}" :disabled="detailsModel.n_zzdzs_like.disabled"  tag='ORMCL_LEVELTWOORG' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_pcmprofilename_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_pcmprofilename_like' :itemRules="this.rules.n_pcmprofilename_like" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_pcmprofilename_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_pcmprofilename_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_pcmprofilename_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_pcmprofilename_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_certificatenumber_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_certificatenumber_like' :itemRules="this.rules.n_certificatenumber_like" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_certificatenumber_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_certificatenumber_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_certificatenumber_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_certificatenumber_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_gender_eq.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_gender_eq' :itemRules="this.rules.n_gender_eq" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_gender_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_gender_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_gender_eq" :data="data" :itemParam="{}" :disabled="detailsModel.n_gender_eq.disabled"  tag='PIMCL_XB' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_yglx_eq.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_yglx_eq' :itemRules="this.rules.n_yglx_eq" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_yglx_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_yglx_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_yglx_eq" :data="data" :itemParam="{}" :disabled="detailsModel.n_yglx_eq.disabled"  tag='PCMCL_SBLX' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_r_lastschool_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_r_lastschool_like' :itemRules="this.rules.n_r_lastschool_like" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_r_lastschool_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_r_lastschool_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_r_lastschool_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_r_lastschool_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_xkml_eq.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_xkml_eq' :itemRules="this.rules.n_xkml_eq" class='' :caption="$t('entities.pcmprofile.serach_rlsb_xyzp_searchform.details.n_xkml_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_xkml_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_xkml_eq" :data="data" :itemParam="{}" :disabled="detailsModel.n_xkml_eq.disabled"  tag='PCMCL_XKML' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
          </app-form-item>
          
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
import PCMPROFILEService from '@/service/pcmprofile/pcmprofile-service';
import Serach_RLSB_XYZPService from './serach-rlsb-xyzp-searchform-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class Serach_RLSB_XYZPBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Serach_RLSB_XYZP
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Serach_RLSB_XYZP
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Serach_RLSB_XYZP
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Serach_RLSB_XYZP
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Serach_RLSB_XYZP
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Serach_RLSB_XYZP
     */
    public getControlType(): string {
        return 'SEARCHFORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Serach_RLSB_XYZP
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {Serach_RLSB_XYZPService}
     * @memberof Serach_RLSB_XYZP
     */
    public service: Serach_RLSB_XYZPService = new Serach_RLSB_XYZPService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PCMPROFILEService}
     * @memberof Serach_RLSB_XYZP
     */
    public appEntityService: PCMPROFILEService = new PCMPROFILEService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Serach_RLSB_XYZP
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Serach_RLSB_XYZP
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Serach_RLSB_XYZPBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Serach_RLSB_XYZPBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Serach_RLSB_XYZPBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Serach_RLSB_XYZPBase
     */
    @Prop() public loadAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof Serach_RLSB_XYZPBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof Serach_RLSB_XYZPBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof Serach_RLSB_XYZPBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof Serach_RLSB_XYZPBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Serach_RLSB_XYZPBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof Serach_RLSB_XYZPBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Serach_RLSB_XYZPBase
     */
    public data: any = {
        n_zzdzs_like: null,
        n_pcmprofilename_like: null,
        n_certificatenumber_like: null,
        n_gender_eq: null,
        n_yglx_eq: null,
        n_r_lastschool_like: null,
        n_xkml_eq: null,
    };

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Serach_RLSB_XYZPBase
     */
    public rules: any = {
        n_zzdzs_like: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        n_pcmprofilename_like: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        n_certificatenumber_like: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        n_gender_eq: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        n_yglx_eq: [
            { type: 'string', message: '申报类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '申报类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '申报类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '申报类型 值不能为空', trigger: 'blur' },
        ],
        n_r_lastschool_like: [
            { type: 'string', message: '毕业院校 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '毕业院校 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '毕业院校 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '毕业院校 值不能为空', trigger: 'blur' },
        ],
        n_xkml_eq: [
            { type: 'string', message: '一级学科 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '一级学科 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '一级学科 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '一级学科 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Serach_RLSB_XYZPBase
     */
    public detailsModel: any = {
        formpage1: new FormPageModel({ caption: '常规条件', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_zzdzs_like: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'n_zzdzs_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_pcmprofilename_like: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'n_pcmprofilename_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_certificatenumber_like: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'n_certificatenumber_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_gender_eq: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'n_gender_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_yglx_eq: new FormItemModel({ caption: '申报类型', detailType: 'FORMITEM', name: 'n_yglx_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_r_lastschool_like: new FormItemModel({ caption: '毕业院校', detailType: 'FORMITEM', name: 'n_r_lastschool_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_xkml_eq: new FormItemModel({ caption: '一级学科', detailType: 'FORMITEM', name: 'n_xkml_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 n_zzdzs_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_zzdzs_like')
    onN_zzdzs_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_zzdzs_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_pcmprofilename_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_pcmprofilename_like')
    onN_pcmprofilename_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_pcmprofilename_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_certificatenumber_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_certificatenumber_like')
    onN_certificatenumber_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_certificatenumber_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_gender_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_gender_eq')
    onN_gender_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_gender_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_yglx_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_yglx_eq')
    onN_yglx_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_yglx_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_r_lastschool_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_r_lastschool_like')
    onN_r_lastschool_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_r_lastschool_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_xkml_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Serach_RLSB_XYZPBase
     */
    @Watch('data.n_xkml_eq')
    onN_xkml_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_xkml_eq', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Serach_RLSB_XYZPBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Serach_RLSB_XYZPBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                








    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图搜索表单loadAction参数未配置' });
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public loadDraft(opt: any = {},mode?:string): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图搜索表单loaddraftAction参数未配置' });
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
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
     * @memberof Serach_RLSB_XYZPBase
     */
    public onReset() {
        this.loadDraft({},'RESET');
    }
}
</script>

<style lang='less'>
@import './serach-rlsb-xyzp-searchform.less';
</style>