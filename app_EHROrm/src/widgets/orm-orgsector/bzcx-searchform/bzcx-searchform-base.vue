<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.n_orgname_like.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
              <app-form-item name='n_orgname_like' :itemRules="this.rules.n_orgname_like" class='' :caption="$t('entities.ormorgsector.bzcx_searchform.details.n_orgname_like')" uiStyle="DEFAULT" :labelWidth="160" :isShowCaption="true" :error="detailsModel.n_orgname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_orgname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_orgname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_orgsectorname_like.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
              <app-form-item name='n_orgsectorname_like' :itemRules="this.rules.n_orgsectorname_like" class='' :caption="$t('entities.ormorgsector.bzcx_searchform.details.n_orgsectorname_like')" uiStyle="DEFAULT" :labelWidth="160" :isShowCaption="true" :error="detailsModel.n_orgsectorname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_orgsectorname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_orgsectorname_like.disabled" type='text'  style=""></input-box>
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
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';
import BZCXService from './bzcx-searchform-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class BZCXBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof BZCXBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof BZCXBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof BZCXBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof BZCXBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof BZCXBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof BZCXBase
     */
    public getControlType(): string {
        return 'SEARCHFORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof BZCXBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {BZCXService}
     * @memberof BZCXBase
     */
    public service: BZCXService = new BZCXService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof BZCXBase
     */
    public appEntityService: OrmOrgsectorService = new OrmOrgsectorService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof BZCXBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof BZCXBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof BZCXBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof BZCXBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof BZCXBase
     */
    @Prop() public loadAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof BZCXBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof BZCXBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof BZCXBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof BZCXBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof BZCXBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof BZCXBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof BZCXBase
     */
    public data: any = {
        n_orgname_like: null,
        n_orgsectorname_like: null,
    };

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof BZCXBase
     */
    public rules: any = {
        n_orgname_like: [
            { type: 'string', message: '组织机构 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织机构 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织机构 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织机构 值不能为空', trigger: 'blur' },
        ],
        n_orgsectorname_like: [
            { type: 'string', message: '部门/项目部名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门/项目部名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门/项目部名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门/项目部名称 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof BZCXBase
     */
    public detailsModel: any = {
        formpage1: new FormPageModel({ caption: '分页', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_orgname_like: new FormItemModel({ caption: '组织机构', detailType: 'FORMITEM', name: 'n_orgname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_orgsectorname_like: new FormItemModel({ caption: '部门/项目部名称', detailType: 'FORMITEM', name: 'n_orgsectorname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 n_orgname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BZCXBase
     */
    @Watch('data.n_orgname_like')
    onN_orgname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_orgname_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_orgsectorname_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BZCXBase
     */
    @Watch('data.n_orgsectorname_like')
    onN_orgsectorname_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_orgsectorname_like', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof BZCXBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof BZCXBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                



    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'ORMORGSECTORBZCXGridView视图搜索表单loadAction参数未配置' });
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
     * @memberof BZCXBase
     */
    public loadDraft(opt: any = {},mode?:string): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'ORMORGSECTORBZCXGridView视图搜索表单loaddraftAction参数未配置' });
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
     * @memberof BZCXBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof BZCXBase
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
     * @memberof BZCXBase
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
     * @memberof BZCXBase
     */
    public onReset() {
        this.loadDraft({},'RESET');
    }
}
</script>

<style lang='less'>
@import './bzcx-searchform.less';
</style>