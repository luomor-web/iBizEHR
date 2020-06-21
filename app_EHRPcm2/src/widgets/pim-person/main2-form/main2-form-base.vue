<template>
    <i-form :model="this.data" class='app-form info-form-mode' ref='form'  id='pimperson_main2' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.main2_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="2" :isInfoGroupMode="true" >    
    <row>
        <i-col v-show="detailsModel.ygbh.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.pimperson.main2_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='ygbh' :value="data.ygbh" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.pimperson.main2_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='pimpersonname' :value="data.pimpersonname" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.pimperson.main2_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='ormorgname' :value="data.ormorgname" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgsectorname.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='ormorgsectorname' :itemRules="this.rules.ormorgsectorname" class='' :caption="$t('entities.pimperson.main2_form.details.ormorgsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='ormorgsectorname' :value="data.ormorgsectorname" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rank.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='rank' :itemRules="this.rules.rank" class='' :caption="$t('entities.pimperson.main2_form.details.rank')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rank.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='rank' :value="data.rank" tag='EhrCodeList0025' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zw.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='zw' :itemRules="this.rules.zw" class='' :caption="$t('entities.pimperson.main2_form.details.zw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zw.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='zw' :value="data.zw" tag='EhrCodeList0233' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gw.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='gw' :itemRules="this.rules.gw" class='' :caption="$t('entities.pimperson.main2_form.details.gw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gw.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='gw' :value="data.gw" tag='EhrCodeList0050' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.csrq.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='csrq' :itemRules="this.rules.csrq" class='' :caption="$t('entities.pimperson.main2_form.details.csrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.csrq.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='csrq' :value="data.csrq" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lxdh.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='lxdh' :itemRules="this.rules.lxdh" class='' :caption="$t('entities.pimperson.main2_form.details.lxdh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lxdh.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='lxdh' :value="data.lxdh" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfznl.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='sfznl' :itemRules="this.rules.sfznl" class='' :caption="$t('entities.pimperson.main2_form.details.sfznl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfznl.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='sfznl' :value="data.sfznl" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.postaladdress.visible" :style="{}"  :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-item name='postaladdress' :itemRules="this.rules.postaladdress" class='' :caption="$t('entities.pimperson.main2_form.details.postaladdress')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.postaladdress.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='postaladdress' :value="data.postaladdress" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.main2_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="true" >    
    <row>
        <i-col v-show="detailsModel.sjtxrq.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='sjtxrq' :itemRules="this.rules.sjtxrq" class='' :caption="$t('entities.pimperson.main2_form.details.sjtxrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sjtxrq.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='sjtxrq' :value="data.sjtxrq" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.txnx.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='txnx' :itemRules="this.rules.txnx" class='' :caption="$t('entities.pimperson.main2_form.details.txnx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.txnx.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='txnx' :value="data.txnx" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.retiplace.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='retiplace' :itemRules="this.rules.retiplace" class='' :caption="$t('entities.pimperson.main2_form.details.retiplace')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.retiplace.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='retiplace' :value="data.retiplace" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

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
import PimPersonService from '@/service/pim-person/pim-person-service';
import Main2Service from './main2-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class Main2Base extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main2Base
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main2Base
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main2Base
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main2Base
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main2Base
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main2Base
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {Main2Service}
     * @memberof Main2Base
     */
    public service: Main2Service = new Main2Service({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimPersonService}
     * @memberof Main2Base
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main2Base
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main2Base
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
     * 工作流审批意见控件绑定值
     *
     * @memberof Main2Base
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main2Base
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main2Base
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof Main2Base
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main2Base
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof Main2Base
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof Main2Base
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof Main2Base
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof Main2Base
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main2Base
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof Main2Base
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Main2Base
     */
    public data: any = {
        srfupdatedate: null,
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        srfip_ygbh: null,
        srfip_pimpersonname: null,
        pimpersonid: null,
        ygbh: null,
        pimpersonname: null,
        ormorgname: null,
        ormorgsectorname: null,
        rank: null,
        zw: null,
        gw: null,
        csrq: null,
        lxdh: null,
        sfznl: null,
        postaladdress: null,
        sjtxrq: null,
        txnx: null,
        retiplace: null,
        pimperson:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof Main2Base
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof Main2Base
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof Main2Base
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof Main2Base
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main2Base
     */
    public rules: any = {
        srfupdatedate: [
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'blur' },
        ],
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        srftempmode: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfuf: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfdeid: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfsourcekey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfip_ygbh: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfip_pimpersonname: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        ygbh: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        pimpersonname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorname: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        rank: [
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'blur' },
        ],
        zw: [
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'blur' },
        ],
        gw: [
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'blur' },
        ],
        csrq: [
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        lxdh: [
            { type: 'string', message: '手机号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '手机号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '手机号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '手机号码 值不能为空', trigger: 'blur' },
        ],
        sfznl: [
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'blur' },
        ],
        postaladdress: [
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'blur' },
        ],
        sjtxrq: [
            { type: 'string', message: '拟退休日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '拟退休日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '拟退休日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '拟退休日期 值不能为空', trigger: 'blur' },
        ],
        txnx: [
            { type: 'string', message: '退休到期(月) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '退休到期(月) 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '退休到期(月) 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '退休到期(月) 值不能为空', trigger: 'blur' },
        ],
        retiplace: [
            { type: 'string', message: '退休地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '退休地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '退休地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '退休地 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main2Base
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '人员信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.main2_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '退休信息', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.main2_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_ygbh: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_pimpersonname: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormorgname: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormorgsectorname: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'ormorgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        rank: new FormItemModel({ caption: '职级', detailType: 'FORMITEM', name: 'rank', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zw: new FormItemModel({ caption: '职务', detailType: 'FORMITEM', name: 'zw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        gw: new FormItemModel({ caption: '岗位', detailType: 'FORMITEM', name: 'gw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        csrq: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'csrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        lxdh: new FormItemModel({ caption: '手机号码', detailType: 'FORMITEM', name: 'lxdh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfznl: new FormItemModel({ caption: '年龄', detailType: 'FORMITEM', name: 'sfznl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        postaladdress: new FormItemModel({ caption: '通讯地址', detailType: 'FORMITEM', name: 'postaladdress', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sjtxrq: new FormItemModel({ caption: '拟退休日期', detailType: 'FORMITEM', name: 'sjtxrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        txnx: new FormItemModel({ caption: '退休到期(月)', detailType: 'FORMITEM', name: 'txnx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        retiplace: new FormItemModel({ caption: '退休地', detailType: 'FORMITEM', name: 'retiplace', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfupdatedate')
    onSrfupdatedateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfupdatedate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srforikey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srforikey')
    onSrforikeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srforikey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfkey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfkey')
    onSrfkeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfkey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfmajortext 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfmajortext')
    onSrfmajortextChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfmajortext', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srftempmode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srftempmode')
    onSrftempmodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srftempmode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfuf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfuf')
    onSrfufChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfuf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfdeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfdeid')
    onSrfdeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfdeid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfsourcekey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfip_ygbh')
    onSrfip_ygbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.srfip_pimpersonname')
    onSrfip_pimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.ygbh')
    onYgbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.pimpersonname')
    onPimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.ormorgsectorname')
    onOrmorgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rank 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.rank')
    onRankChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rank', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.zw')
    onZwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.gw')
    onGwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 csrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.csrq')
    onCsrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'csrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lxdh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.lxdh')
    onLxdhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lxdh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfznl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.sfznl')
    onSfznlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfznl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 postaladdress 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.postaladdress')
    onPostaladdressChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'postaladdress', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sjtxrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.sjtxrq')
    onSjtxrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sjtxrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 txnx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.txnx')
    onTxnxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'txnx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 retiplace 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main2Base
     */
    @Watch('data.retiplace')
    onRetiplaceChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'retiplace', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main2Base
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof Main2Base
      */
    public ResetData(_datas:any){
        if(Object.keys(_datas).length >0){
            Object.keys(_datas).forEach((name: string) => {
                if (this.data.hasOwnProperty(name)) {
                    this.data[name] = null;
                }
            });
        }
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main2Base
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                




























    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof Main2Base
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
     * @param {string} [action]
     * @memberof Main2Base
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.pimperson){
            Object.assign(this.context,{pimperson:data.pimperson})
        }
        this.setFormEnableCond(data);
        this.fillForm(data,action);
        this.oldData = {};
        Object.assign(this.oldData, JSON.parse(JSON.stringify(this.data)));
        this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: false });
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @param {string} [action]
     * @memberof Main2Base
     */
    public fillForm(_datas: any = {},action:string): void {
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        if(Object.is(action,'loadDraft')){
            this.createDefault();
        }
        if(Object.is(action,'load')){
            this.updateDefault();
        }
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof Main2Base
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
     * @memberof Main2Base
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
     * @memberof Main2Base
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
     * @memberof Main2Base
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
     * @memberof Main2Base
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.form;
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
     * @memberof Main2Base
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof Main2Base
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
     * @memberof Main2Base
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
     * @memberof Main2Base
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
     * @memberof Main2Base
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main2Base
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
                    if(this.context.srfsourcekey){
                        this.copy(this.context.srfsourcekey);
                    }else{
                        this.loadDraft(data);
                    }
                }
                if (Object.is('save', action)) {
                    this.save(data,data.showResultInfo);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('saveandexit', action)) {
                    this.saveAndExit(data);
                }
                if (Object.is('saveandnew', action)) {
                    this.saveAndNew(data);
                }
                if (Object.is('removeandexit', action)) {
                    this.removeAndExit(data);
                }
                if (Object.is('refresh', action)) {
                    this.refresh(data);
                }
            });
        }
        this.dataChang
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            ).subscribe((data: any) => {
                if (this.autosave) {
                    this.autoSave();
                }
                const state = !Object.is(JSON.stringify(this.oldData), JSON.stringify(this.data)) ? true : false;
                this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: state });
            });
    }

    /**
     * vue 生命周期
     *
     * @memberof Main2Base
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main2Base
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
     * 拷贝内容
     *
     * @param {*} [arg={}]
     * @memberof @memberof Main2Base
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.pimperson = copyData.srfkey;
        copyData.pimpersonid = copyData.srfkey;
        Object.assign(this.context,{pimperson:copyData.pimperson})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof Main2Base
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'pimperson_main2',popTitle:'退休主信息表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main2Base
     */
    public refresh(args: any[]): void {
        let arg: any = {};
        Object.assign(arg,args[0]);
        if (this.data.srfkey && !Object.is(this.data.srfkey, '')) {
            Object.assign(arg, { srfkey: this.data.srfkey });
            this.load(arg);
            return;
        }
        if (this.data.srfkeys && !Object.is(this.data.srfkeys, '')) {
            Object.assign(arg, { srfkey: this.data.srfkeys });
            this.load(arg);
            return;
        }
    }

    /**
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof Main2Base
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
     * @memberof Main2Base
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PimPersonEditView9视图表单loadAction参数未配置' });
            return;
        }
        const arg: any = { ...opt };
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.onFormLoad(data,'load');
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof Main2Base
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PimPersonEditView9视图表单loaddraftAction参数未配置' });
            return;
        }
        const arg: any = { ...opt } ;
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            if(data.pimperson){
                Object.assign(this.context,{pimperson:data.pimperson})
            }
            this.resetDraftFormStates();
            this.onFormLoad(data,'loadDraft');
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
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
        }).catch((response: any) => {
            if (response && response.status  && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 自动保存
     *
     * @param {*} [opt={}]
     * @memberof Main2Base
     */
    public autoSave(opt: any = {}): void {
        if (!this.formValidateStatus()) {
            return;
        }
        const arg: any = { ...opt };
        const data = this.getValues();
        Object.assign(arg, data);
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: '错误', desc: 'PimPersonEditView9视图表单'+actionName+'参数未配置' });
            return;
        }
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.add(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.onFormLoad(data,'autoSave');
            this.$emit('save', data);
            this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 保存
     *
     * @param {*} [opt={}]
     * @param {boolean} [showResultInfo] 
     * @param {boolean} [ifStateNext] formState是否下发通知
     * @returns {Promise<any>}
     * @memberof Main2Base
     */
    public async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            showResultInfo = showResultInfo === undefined ? true : false;
            if (!this.formValidateStatus()) {
                this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
                return;
            }
            const arg: any = { ...opt };
            const data = this.getValues();
            Object.assign(arg, data);
            Object.assign(arg, this.context);
            if (ifStateNext) {
                this.drcounter = 0;
                if(this.drcounter !== 0){
                    this.drsaveopt = opt;
                    this.formState.next({ type: 'beforesave', data: arg });//先通知关系界面保存
                    this.saveState = resolve;
                    return;
                }
            }
            const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
            if(!action){
                let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
                this.$Notice.error({ title: '错误', desc: 'PimPersonEditView9视图表单'+actionName+'参数未配置' });
                return;
            }
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(data.srfuf, '1')?this.service.update(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(action,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
            post.then((response: any) => {
                if (!response.status || response.status !== 200) {
                    if (response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                    }
                    return;
                }

                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;保存成功！' });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status  && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
        })
    }

    /**
    * 删除
    *
    * @public
    * @param {*} [opt={}]
    * @memberof Main2Base
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'PimPersonEditView9视图表单removeAction参数未配置' });
                return;
            }
            const arg: any = opt[0];
            const _this: any = this;
            Object.assign(arg,{viewparams:this.viewparams});
            this.service.delete(_this.removeAction, JSON.parse(JSON.stringify(this.context)),arg, showResultInfo).then((response: any) => {
                if (response) {
                    const data = response.data;
                    this.$emit('remove',data);
                    this.formState.next({ type: 'remove', data: data });
                    this.data.ismodify = false;
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;删除成功！' });
                    resolve(response);
                }
            }).catch((error: any) => {
                const { data: _data } = error;
                this.$Notice.error({ title: _data.title, desc: _data.message });
                reject(error);
            });
        });
    }

    /**
     * 工作流启动
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof Main2Base
     */
    public async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const post: Promise<any> = _this.save({},false);
            post.then((response:any) =>{
                const arg:any = response.data;
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                const result: Promise<any> = this.service.wfstart(_this.WFStartAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流启动失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.$Notice.info({ title: '', desc: '工作流启动成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        });
    }

    /**
     * 工作流提交
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof Main2Base
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.pimperson || Object.is(arg.pimperson, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备提交参数
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                // 强制补充srfwfmemo
                if(this.srfwfmemo){
                    Object.assign(arg,{srfwfmemo:this.srfwfmemo});
                }
                const result: Promise<any> = this.service.wfsubmit(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流提交失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.onFormLoad(arg,'submit');
                    this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                    this.$Notice.info({ title: '', desc: '工作流提交成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        })
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof Main2Base
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = { ...data };
        Object.assign(arg,this.viewparams);
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '错误', desc: '表单项更新失败' });
                return;
            }
            const data = response.data;
            const _data: any = {};
            updateDetails.forEach((name: string) => {
                if (!data.hasOwnProperty(name)) {
                    return;
                }
                Object.assign(_data, { [name]: data[name] });
            });
            this.setFormEnableCond(_data);
            this.fillForm(_data,'updateFormItem');
            this.formLogic({ name: '', newVal: null, oldVal: null });
            this.dataChang.next(JSON.stringify(this.data));
            this.$nextTick(() => {
                this.formState.next({ type: 'updateformitem', ufimode: arg.srfufimode, data: _data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof Main2Base
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof Main2Base
     */
    public saveAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndExit";
            _this.save([arg]).then((res) =>{
                if(res){
                    _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 保存并新建
     *
     * @param {any[]} args
     * @memberof Main2Base
     */
    public saveAndNew(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndNew";
            _this.save([arg]).then((res) =>{
                _this.ResetData(res);
                _this.loadDraft({});
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 删除并退出
     *
     * @param {any[]} args
     * @memberof Main2Base
     */
    public removeAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.remove([arg]).then((res) =>{
                if(res){
                  _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
    * 关系界面数据保存完成
    *
    * @param {any} $event
    * @memberof Main2Base
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter === 0){
            this.save(this.drsaveopt, undefined, false).then((res) =>{
                this.saveState(res);
                this.drsaveopt = {};
                if(Object.is(_this.currentAction, "saveAndNew")){
                    _this.ResetData(res);
                    _this.loadDraft({});
                }else if(Object.is(_this.currentAction, "saveAndExit")){
                    if(res){
                        _this.closeView(res.data);
                    }
                }
            });
        }
    }

    /**
     * 新建默认值
     * @memberof Main2Base
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof Main2Base
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main2-form.less';
</style>