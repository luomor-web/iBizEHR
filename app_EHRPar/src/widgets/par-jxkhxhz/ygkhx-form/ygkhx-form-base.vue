<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='parjxkhxhz_ygkhx' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.parjxkhxhz.ygkhx_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.xh.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='xh' :itemRules="this.rules.xh" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.xh')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.xh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xh.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.khlx.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='khlx' :itemRules="this.rules.khlx" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.khlx')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.khlx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.khlx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.khlx.disabled"  
    tag='EhrCodeList0015' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yg.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='yg' :itemRules="this.rules.yg" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.yg')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.yg.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.yg"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.yg.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zz.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='zz' :itemRules="this.rules.zz" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.zz')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.zz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bm.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='bm' :itemRules="this.rules.bm" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.bm')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.bm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzjx.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='gzjx' :itemRules="this.rules.gzjx" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.gzjx')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.gzjx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gzjx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gzjx.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jswmjc.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='jswmjc' :itemRules="this.rules.jswmjc" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.jswmjc')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.jswmjc.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jswmjc"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jswmjc.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ywnlks.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ywnlks' :itemRules="this.rules.ywnlks" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.ywnlks')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.ywnlks.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ywnlks"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ywnlks.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gznljtd.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='gznljtd' :itemRules="this.rules.gznljtd" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.gznljtd')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.gznljtd.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gznljtd"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gznljtd.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gznljtd_xbn.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='gznljtd_xbn' :itemRules="this.rules.gznljtd_xbn" class='' :caption="$t('entities.parjxkhxhz.ygkhx_form.details.gznljtd_xbn')" uiStyle="DEFAULT" :labelWidth="200" :isShowCaption="true" :error="detailsModel.gznljtd_xbn.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gznljtd_xbn"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gznljtd_xbn.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

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
import ParJxkhxhzService from '@/service/par-jxkhxhz/par-jxkhxhz-service';
import YGKHXService from './ygkhx-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class YGKHXBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof YGKHX
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof YGKHX
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof YGKHX
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof YGKHX
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof YGKHX
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof YGKHX
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {YGKHXService}
     * @memberof YGKHX
     */
    public service: YGKHXService = new YGKHXService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {ParJxkhxhzService}
     * @memberof YGKHX
     */
    public appEntityService: ParJxkhxhzService = new ParJxkhxhzService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof YGKHX
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof YGKHX
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof YGKHX
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof YGKHX
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof YGKHX
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof YGKHX
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof YGKHX
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof YGKHX
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof YGKHX
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof YGKHX
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof YGKHX
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof YGKHX
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
        parjxkhxhzname: null,
        ygid: null,
        xh: null,
        khlx: null,
        yg: null,
        zz: null,
        bm: null,
        gzjx: null,
        jswmjc: null,
        ywnlks: null,
        gznljtd: null,
        gznljtd_xbn: null,
        parjxkhxhzid: null,
        parjxkhxhz:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof YGKHX
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof YGKHX
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof YGKHX
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof YGKHX
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof YGKHX
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
            { type: 'string', message: '绩效考核项得分汇总标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '绩效考核项得分汇总标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '绩效考核项得分汇总标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '绩效考核项得分汇总标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '绩效考核项得分汇总名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '绩效考核项得分汇总名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '绩效考核项得分汇总名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '绩效考核项得分汇总名称 值不能为空', trigger: 'blur' },
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
        parjxkhxhzname: [
            { type: 'string', message: '绩效考核项得分汇总名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '绩效考核项得分汇总名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '绩效考核项得分汇总名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '绩效考核项得分汇总名称 值不能为空', trigger: 'blur' },
        ],
        ygid: [
            { type: 'string', message: '员工ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工ID 值不能为空', trigger: 'blur' },
        ],
        xh: [
            { type: 'number', message: '排序号 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '排序号 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '排序号 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '排序号 值不能为空', trigger: 'blur' },
        ],
        khlx: [
            { type: 'string', message: '考核对象 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考核对象 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考核对象 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考核对象 值不能为空', trigger: 'blur' },
        ],
        yg: [
            { type: 'string', message: '员工 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工 值不能为空', trigger: 'blur' },
        ],
        zz: [
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属组织 值不能为空', trigger: 'blur' },
        ],
        bm: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        gzjx: [
            { type: 'number', message: '年度量化目标（工作述职） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年度量化目标（工作述职） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年度量化目标（工作述职） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年度量化目标（工作述职） 值不能为空', trigger: 'blur' },
        ],
        jswmjc: [
            { type: 'number', message: '月度考核 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '月度考核 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '月度考核 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '月度考核 值不能为空', trigger: 'blur' },
        ],
        ywnlks: [
            { type: 'number', message: '工作周报考核 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '工作周报考核 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '工作周报考核 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '工作周报考核 值不能为空', trigger: 'blur' },
        ],
        gznljtd: [
            { type: 'number', message: '工作能力及态度评价（上半年） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '工作能力及态度评价（上半年） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '工作能力及态度评价（上半年） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '工作能力及态度评价（上半年） 值不能为空', trigger: 'blur' },
        ],
        gznljtd_xbn: [
            { type: 'number', message: '工作能力及态度评价（下半年） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '工作能力及态度评价（下半年） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '工作能力及态度评价（下半年） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '工作能力及态度评价（下半年） 值不能为空', trigger: 'blur' },
        ],
        parjxkhxhzid: [
            { type: 'string', message: '绩效考核项得分汇总标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '绩效考核项得分汇总标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '绩效考核项得分汇总标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '绩效考核项得分汇总标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof YGKHX
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '考核内容评分汇总', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.parjxkhxhz.ygkhx_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '绩效考核项得分汇总标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '绩效考核项得分汇总名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parjxkhxhzname: new FormItemModel({ caption: '绩效考核项得分汇总名称', detailType: 'FORMITEM', name: 'parjxkhxhzname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygid: new FormItemModel({ caption: '员工ID', detailType: 'FORMITEM', name: 'ygid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xh: new FormItemModel({ caption: '排序号', detailType: 'FORMITEM', name: 'xh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        khlx: new FormItemModel({ caption: '考核对象', detailType: 'FORMITEM', name: 'khlx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yg: new FormItemModel({ caption: '员工', detailType: 'FORMITEM', name: 'yg', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zz: new FormItemModel({ caption: '所属组织', detailType: 'FORMITEM', name: 'zz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bm: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'bm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzjx: new FormItemModel({ caption: '年度量化目标（工作述职）', detailType: 'FORMITEM', name: 'gzjx', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jswmjc: new FormItemModel({ caption: '月度考核', detailType: 'FORMITEM', name: 'jswmjc', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ywnlks: new FormItemModel({ caption: '工作周报考核', detailType: 'FORMITEM', name: 'ywnlks', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gznljtd: new FormItemModel({ caption: '工作能力及态度评价（上半年）', detailType: 'FORMITEM', name: 'gznljtd', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gznljtd_xbn: new FormItemModel({ caption: '工作能力及态度评价（下半年）', detailType: 'FORMITEM', name: 'gznljtd_xbn', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parjxkhxhzid: new FormItemModel({ caption: '绩效考核项得分汇总标识', detailType: 'FORMITEM', name: 'parjxkhxhzid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parjxkhxhzname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.parjxkhxhzname')
    onParjxkhxhznameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parjxkhxhzname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.ygid')
    onYgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.xh')
    onXhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 khlx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.khlx')
    onKhlxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'khlx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yg 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.yg')
    onYgChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yg', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.zz')
    onZzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.bm')
    onBmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzjx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.gzjx')
    onGzjxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzjx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jswmjc 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.jswmjc')
    onJswmjcChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jswmjc', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ywnlks 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.ywnlks')
    onYwnlksChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ywnlks', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gznljtd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.gznljtd')
    onGznljtdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gznljtd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gznljtd_xbn 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.gznljtd_xbn')
    onGznljtd_xbnChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gznljtd_xbn', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parjxkhxhzid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof YGKHX
     */
    @Watch('data.parjxkhxhzid')
    onParjxkhxhzidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parjxkhxhzid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof YGKHX
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
      * @memberof EditForm
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
     * @memberof YGKHX
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                

















        if (Object.is(name, '') || Object.is(name, 'gzjx')) {
            let ret = false;
            const _gzjx = this.data.gzjx;
            if (this.$verify.testCond(_gzjx, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.gzjx.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'jswmjc')) {
            let ret = false;
            const _jswmjc = this.data.jswmjc;
            if (this.$verify.testCond(_jswmjc, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.jswmjc.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'ywnlks')) {
            let ret = false;
            const _ywnlks = this.data.ywnlks;
            if (this.$verify.testCond(_ywnlks, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.ywnlks.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'gznljtd')) {
            let ret = false;
            const _gznljtd = this.data.gznljtd;
            if (this.$verify.testCond(_gznljtd, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.gznljtd.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'gznljtd_xbn')) {
            let ret = false;
            const _gznljtd_xbn = this.data.gznljtd_xbn;
            if (this.$verify.testCond(_gznljtd_xbn, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.gznljtd_xbn.setVisible(ret);
        }


    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.parjxkhxhz){
            Object.assign(this.context,{parjxkhxhz:data.parjxkhxhz})
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof YGKHX
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
     * @memberof YGKHX
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof YGKHX
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
     * @memberof @memberof YGKHX
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.parjxkhxhz = copyData.srfkey;
        copyData.parjxkhxhzid = copyData.srfkey;
        Object.assign(this.context,{parjxkhxhz:copyData.parjxkhxhz})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof YGKHX
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'parjxkhxhz_ygkhx',popTitle:'员工考核内容评分汇总'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'ParJxkhxhzYGKHXEditView视图表单loadAction参数未配置' });
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
     * @memberof YGKHX
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'ParJxkhxhzYGKHXEditView视图表单loaddraftAction参数未配置' });
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
            if(data.parjxkhxhz){
                Object.assign(this.context,{parjxkhxhz:data.parjxkhxhz})
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
     * @memberof YGKHX
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
            this.$Notice.error({ title: '错误', desc: 'ParJxkhxhzYGKHXEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof YGKHX
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
                this.$Notice.error({ title: '错误', desc: 'ParJxkhxhzYGKHXEditView视图表单'+actionName+'参数未配置' });
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
    * @memberof EditForm
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'ParJxkhxhzYGKHXEditView视图表单removeAction参数未配置' });
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.parjxkhxhz || Object.is(arg.parjxkhxhz, '')) {
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
     * @memberof YGKHX
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
     * @memberof YGKHX
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof YGKHX
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
     * @memberof YGKHX
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
     * @memberof YGKHX
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
    * @memberof YGKHX
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter > 0){
            return;
        }
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

    /**
     * 新建默认值
     * @memberof YGKHX
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof YGKHX
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './ygkhx-form.less';
</style>