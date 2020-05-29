<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.n_pimpersonname_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_pimpersonname_like' :itemRules="this.rules.n_pimpersonname_like" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_pimpersonname_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_pimpersonname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_pimpersonname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_pimpersonname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ygbh_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_ygbh_like' :itemRules="this.rules.n_ygbh_like" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_ygbh_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ygbh_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_ygbh_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_ygbh_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_zjhm_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_zjhm_like' :itemRules="this.rules.n_zjhm_like" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_zjhm_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_zjhm_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_zjhm_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_zjhm_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormorgname_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormorgname_like' :itemRules="this.rules.n_ormorgname_like" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_ormorgname_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormorgname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_ormorgname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_ormorgname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormorgsectorname_like.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormorgsectorname_like' :itemRules="this.rules.n_ormorgsectorname_like" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_ormorgsectorname_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormorgsectorname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_ormorgsectorname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_ormorgsectorname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ygzt_eq.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_ygzt_eq' :itemRules="this.rules.n_ygzt_eq" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_ygzt_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ygzt_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_ygzt_eq" :data="data" :itemParam="{}" :disabled="detailsModel.n_ygzt_eq.disabled"  tag='PIMCL_YGZT' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_zgcode_eq.visible" :style="{}"  :sm="{ span: 6, offset: 0 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
              <app-form-item name='n_zgcode_eq' :itemRules="this.rules.n_zgcode_eq" class='' :caption="$t('entities.pimperson.ryinfosearchform_searchform.details.n_zgcode_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_zgcode_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list v-model="data.n_zgcode_eq" :data="data" :itemParam="{}" :disabled="detailsModel.n_zgcode_eq.disabled"  tag='PIMCL_ZGZT' codelistType='STATIC' placeholder='请选择...' style=""></dropdown-list>
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
import PimPersonService from '@/service/pim-person/pim-person-service';
import RYInfoSearchFormService from './ryinfo-search-form-searchform-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class RYInfoSearchFormBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof RYInfoSearchForm
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof RYInfoSearchForm
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof RYInfoSearchForm
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof RYInfoSearchForm
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof RYInfoSearchForm
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof RYInfoSearchForm
     */
    public getControlType(): string {
        return 'SEARCHFORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof RYInfoSearchForm
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {RYInfoSearchFormService}
     * @memberof RYInfoSearchForm
     */
    public service: RYInfoSearchFormService = new RYInfoSearchFormService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimPersonService}
     * @memberof RYInfoSearchForm
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof RYInfoSearchForm
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof RYInfoSearchForm
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
     * @memberof RYInfoSearchFormBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof RYInfoSearchFormBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof RYInfoSearchFormBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof RYInfoSearchFormBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof RYInfoSearchFormBase
     */
    @Prop() public loadAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof RYInfoSearchFormBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof RYInfoSearchFormBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof RYInfoSearchFormBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof RYInfoSearchFormBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof RYInfoSearchFormBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof RYInfoSearchFormBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof RYInfoSearchFormBase
     */
    public data: any = {
        n_pimpersonname_like: null,
        n_ygbh_like: null,
        n_zjhm_like: null,
        n_ormorgname_like: null,
        n_ormorgsectorname_like: null,
        n_ygzt_eq: null,
        n_zgcode_eq: null,
    };

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof RYInfoSearchFormBase
     */
    public rules: any = {
        n_pimpersonname_like: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        n_ygbh_like: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        n_zjhm_like: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        n_ormorgname_like: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        n_ormorgsectorname_like: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        n_ygzt_eq: [
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工状态 值不能为空', trigger: 'blur' },
        ],
        n_zgcode_eq: [
            { type: 'string', message: '在岗状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '在岗状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '在岗状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '在岗状态 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof RYInfoSearchFormBase
     */
    public detailsModel: any = {
        formpage1: new FormPageModel({ caption: '常规条件', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_pimpersonname_like: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'n_pimpersonname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ygbh_like: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'n_ygbh_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_zjhm_like: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'n_zjhm_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgname_like: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'n_ormorgname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgsectorname_like: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'n_ormorgsectorname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ygzt_eq: new FormItemModel({ caption: '员工状态', detailType: 'FORMITEM', name: 'n_ygzt_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_zgcode_eq: new FormItemModel({ caption: '在岗状态', detailType: 'FORMITEM', name: 'n_zgcode_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 n_pimpersonname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_pimpersonname_like')
    onN_pimpersonname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_pimpersonname_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ygbh_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_ygbh_like')
    onN_ygbh_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ygbh_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_zjhm_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_zjhm_like')
    onN_zjhm_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_zjhm_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormorgname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_ormorgname_like')
    onN_ormorgname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgname_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormorgsectorname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_ormorgsectorname_like')
    onN_ormorgsectorname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgsectorname_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ygzt_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_ygzt_eq')
    onN_ygzt_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ygzt_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_zgcode_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoSearchFormBase
     */
    @Watch('data.n_zgcode_eq')
    onN_zgcode_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_zgcode_eq', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof RYInfoSearchFormBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof RYInfoSearchFormBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                








    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PIMPERSONPickupView视图搜索表单loadAction参数未配置' });
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
     * @memberof RYInfoSearchFormBase
     */
    public loadDraft(opt: any = {},mode?:string): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PIMPERSONPickupView视图搜索表单loaddraftAction参数未配置' });
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
     * @memberof RYInfoSearchFormBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
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
     * @memberof RYInfoSearchFormBase
     */
    public onReset() {
        this.loadDraft({},'RESET');
    }
}
</script>

<style lang='less'>
@import './ryinfo-search-form-searchform.less';
</style>