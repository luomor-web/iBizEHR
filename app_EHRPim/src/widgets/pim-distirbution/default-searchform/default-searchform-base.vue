<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.n_ygbh_like.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ygbh_like' :itemRules="this.rules.n_ygbh_like" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_ygbh_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ygbh_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_ygbh_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_ygbh_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_pimpersonname_like.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_pimpersonname_like' :itemRules="this.rules.n_pimpersonname_like" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_pimpersonname_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_pimpersonname_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box v-model="data.n_pimpersonname_like"  @enter="onEnter($event)"    :disabled="detailsModel.n_pimpersonname_like.disabled" type='text'  style=""></input-box>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormorgname_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormorgname_eq' :itemRules="this.rules.n_ormorgname_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_ormorgname_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormorgname_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <app-picker 
            :formState="formState"
            :data="data"
            :context="context"
            :viewparams="viewparams"
            :itemParam='{ }' 
            :disabled="detailsModel.n_ormorgname_eq.disabled"
            name='n_ormorgname_eq'
            deMajorField='orgname'
            deKeyField='ormorg'
            :service="service"
            :acParams="{ serviceName: 'OrmOrgService', interfaceName: 'FetchDefault'}"
            valueitem='n_ormorgid_eq' 
            :value="data.n_ormorgname_eq" 
            editortype="" 
            :pickupView="{ viewname: 'ormorgfpxxpickup-view', title: $t('entities.ormorg.views.fpxxpickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' } ], placement:'' }"
            style=""  
            @formitemvaluechange="onFormItemValueChange">
          </app-picker>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormorgsectorname_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormorgsectorname_eq' :itemRules="this.rules.n_ormorgsectorname_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_ormorgsectorname_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormorgsectorname_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <app-picker 
            :formState="formState"
            :data="data"
            :context="context"
            :viewparams="viewparams"
            :itemParam='{ }' 
            :disabled="detailsModel.n_ormorgsectorname_eq.disabled"
            name='n_ormorgsectorname_eq'
            deMajorField='orgsectorname'
            deKeyField='ormorgsector'
            :service="service"
            :acParams="{ serviceName: 'OrmOrgsectorService', interfaceName: 'FetchCURORG'}"
            valueitem='n_ormorgsectorid_eq' 
            :value="data.n_ormorgsectorname_eq" 
            editortype="" 
            :pickupView="{ viewname: 'ormorgsectorfpxxpickup-view', title: $t('entities.ormorgsector.views.fpxxpickupview.title'), deResParameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, ], parameters: [{ pathName: 'ormorgsectors', parameterName: 'ormorgsector' }, { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' } ], placement:'' }"
            style=""  
            @formitemvaluechange="onFormItemValueChange">
          </app-picker>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormdutyname_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormdutyname_eq' :itemRules="this.rules.n_ormdutyname_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_ormdutyname_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormdutyname_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <app-picker 
            :formState="formState"
            :data="data"
            :context="context"
            :viewparams="viewparams"
            :itemParam='{ }' 
            :disabled="detailsModel.n_ormdutyname_eq.disabled"
            name='n_ormdutyname_eq'
            deMajorField='ormdutyname'
            deKeyField='ormduty'
            :service="service"
            :acParams="{ serviceName: 'OrmDutyService', interfaceName: 'FetchCurOrmorgsector'}"
            valueitem='n_ormdutyid_eq' 
            :value="data.n_ormdutyname_eq" 
            editortype="" 
            :pickupView="{ viewname: 'ormdutyorm-org-sector-pickup-view', title: $t('entities.ormduty.views.ormorgsectorpickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormduties', parameterName: 'ormduty' }, { pathName: 'ormorgsectorpickupview', parameterName: 'ormorgsectorpickupview' } ], placement:'' }"
            style=""  
            @formitemvaluechange="onFormItemValueChange">
          </app-picker>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_ormpostname_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_ormpostname_eq' :itemRules="this.rules.n_ormpostname_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_ormpostname_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_ormpostname_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <app-picker 
            :formState="formState"
            :data="data"
            :context="context"
            :viewparams="viewparams"
            :itemParam='{ }' 
            :disabled="detailsModel.n_ormpostname_eq.disabled"
            name='n_ormpostname_eq'
            deMajorField='ormpostname'
            deKeyField='ormpost'
            :service="service"
            :acParams="{ serviceName: 'OrmPostService', interfaceName: 'FetchEJZZGW'}"
            valueitem='n_ormpostid_eq' 
            :value="data.n_ormpostname_eq" 
            editortype="" 
            :pickupView="{ viewname: 'ormpostejormorgidpickup-view', title: $t('entities.ormpost.views.ejormorgidpickupview.title'), deResParameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, ], parameters: [{ pathName: 'ormposts', parameterName: 'ormpost' }, { pathName: 'ejormorgidpickupview', parameterName: 'ejormorgidpickupview' } ], placement:'' }"
            style=""  
            @formitemvaluechange="onFormItemValueChange">
          </app-picker>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_fplx_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_fplx_eq' :itemRules="this.rules.n_fplx_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_fplx_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_fplx_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_fplx_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_fplx_eq.disabled"  
              tag='EhrCodeList0205' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_cfplx_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_cfplx_eq' :itemRules="this.rules.n_cfplx_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_cfplx_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_cfplx_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_cfplx_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_cfplx_eq.disabled"  
              tag='EhrCodeList0237' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_fpzt_eq.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
              <app-form-item name='n_fpzt_eq' :itemRules="this.rules.n_fpzt_eq" class='' :caption="$t('entities.pimdistirbution.default_searchform.details.n_fpzt_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_fpzt_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
               <dropdown-list 
              v-model="data.n_fpzt_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :itemParam="{}" 
              :disabled="detailsModel.n_fpzt_eq.disabled"  
              tag='EhrCodeList0137' 
              codelistType='DYNAMIC'
              placeholder='请选择...' style="">
           </dropdown-list>
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
import PimDistirbutionService from '@/service/pim-distirbution/pim-distirbution-service';
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
     * @type {PimDistirbutionService}
     * @memberof Default
     */
    public appEntityService: PimDistirbutionService = new PimDistirbutionService({ $store: this.$store });
    


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
        n_ormorgname_eq: null,
        n_ormorgsectorname_eq: null,
        n_ormdutyname_eq: null,
        n_ormpostname_eq: null,
        n_fplx_eq: null,
        n_cfplx_eq: null,
        n_fpzt_eq: null,
        n_ormpostid_eq: null,
        n_ormorgid_eq: null,
        n_ormdutyid_eq: null,
        n_ormorgsectorid_eq: null,
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
        n_ormorgname_eq: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        n_ormorgsectorname_eq: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        n_ormdutyname_eq: [
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'blur' },
        ],
        n_ormpostname_eq: [
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'blur' },
        ],
        n_fplx_eq: [
            { type: 'string', message: '分配(=) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '分配(=) 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '分配(=) 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '分配(=) 值不能为空', trigger: 'blur' },
        ],
        n_cfplx_eq: [
            { type: 'string', message: '类型(=) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '类型(=) 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '类型(=) 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '类型(=) 值不能为空', trigger: 'blur' },
        ],
        n_fpzt_eq: [
            { type: 'string', message: '分配状态(=) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '分配状态(=) 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '分配状态(=) 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '分配状态(=) 值不能为空', trigger: 'blur' },
        ],
        n_ormpostid_eq: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        n_ormorgid_eq: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        n_ormdutyid_eq: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        n_ormorgsectorid_eq: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public detailsModel: any = {
        formpage1: new FormPageModel({ caption: '常规条件', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_ygbh_like: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'n_ygbh_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_pimpersonname_like: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'n_pimpersonname_like', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgname_eq: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'n_ormorgname_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgsectorname_eq: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'n_ormorgsectorname_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormdutyname_eq: new FormItemModel({ caption: '职务', detailType: 'FORMITEM', name: 'n_ormdutyname_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormpostname_eq: new FormItemModel({ caption: '岗位', detailType: 'FORMITEM', name: 'n_ormpostname_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_fplx_eq: new FormItemModel({ caption: '分配(=)', detailType: 'FORMITEM', name: 'n_fplx_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_cfplx_eq: new FormItemModel({ caption: '类型(=)', detailType: 'FORMITEM', name: 'n_cfplx_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_fpzt_eq: new FormItemModel({ caption: '分配状态(=)', detailType: 'FORMITEM', name: 'n_fpzt_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormpostid_eq: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'n_ormpostid_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgid_eq: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'n_ormorgid_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormdutyid_eq: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'n_ormdutyid_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        n_ormorgsectorid_eq: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'n_ormorgsectorid_eq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 n_ormorgname_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormorgname_eq')
    onN_ormorgname_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgname_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormorgsectorname_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormorgsectorname_eq')
    onN_ormorgsectorname_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgsectorname_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormdutyname_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormdutyname_eq')
    onN_ormdutyname_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormdutyname_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormpostname_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormpostname_eq')
    onN_ormpostname_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormpostname_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_fplx_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_fplx_eq')
    onN_fplx_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_fplx_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_cfplx_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_cfplx_eq')
    onN_cfplx_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_cfplx_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_fpzt_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_fpzt_eq')
    onN_fpzt_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_fpzt_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormpostid_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormpostid_eq')
    onN_ormpostid_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormpostid_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormorgid_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormorgid_eq')
    onN_ormorgid_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgid_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormdutyid_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormdutyid_eq')
    onN_ormdutyid_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormdutyid_eq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_ormorgsectorid_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_ormorgsectorid_eq')
    onN_ormorgsectorid_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_ormorgsectorid_eq', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof DefaultBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (Object.is(name, 'ormorgid')) {
            this.onFormItemValueChange({ name: 'n_ormorgsectorname_eq', value: null });
            this.onFormItemValueChange({ name: 'n_ormorgsectorid_eq', value: null });
        }
        if (Object.is(name, 'ormorgid')) {
            this.onFormItemValueChange({ name: 'n_ormpostname_eq', value: null });
            this.onFormItemValueChange({ name: 'n_ormpostid_eq', value: null });
        }
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
            this.$Notice.error({ title: '错误', desc: 'PimDistirbutionJDRYHMCGridView视图搜索表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PimDistirbutionJDRYHMCGridView视图搜索表单loaddraftAction参数未配置' });
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