<template>
 <div class='form-druipart'>
    <component 
      :is="viewname" 
      class="viewcontainer2" 
      :viewdata ="viewdata" 
      :viewDefaultUsage="false"
      :formDruipart="formDruipart"
      :isformDruipart="true"
      @mditemsload="mditemsload" 
      @drdatasaved="drdatasaved"  
      @drdatachange="drdatachange"  
      @viewdataschange="viewdataschange"  
      @viewload="viewload">
    </component> 
    <spin v-if="blockUI" class='app-druipart-spin' fix >{{ $t('components.appFormDRUIPart.blockUITipInfo') }}</spin>            
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { Subject, Unsubscribable } from 'rxjs';
@Component({
})
export default class AppFormDRUIPart extends Vue {

    /**
     * 表单数据
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public data!: string;

    /**
     * 关联视图
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public viewname?: string;

    /**
     * 刷新关系项
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop({ default: '' }) public refreshitems!: string;

    /**
     * 关系视图类型
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public refviewtype?: string;

    /**
     * 父数据
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public parentdata!: any;

    /**
     * 传入参数项名称
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public paramItem!: string;

    /**
     * 是否忽略表单项值变化
     *
     * @type {boolean}
     * @memberof AppFormDRUIPart
     */
    @Prop() public ignorefieldvaluechange!: boolean;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppFormDRUIPart
     */
    @Prop() public formState!: Subject<any>;

    /**
     * 视图参数
     *
     * @type {any[]}
     * @memberof AppFormDRUIPart
     */
    @Prop() public parameters!: any[];

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public viewparams!: any;

    /**
     * 应用实体参数名称
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public parameterName!: string;

    /**
     * 应用实体参数名称(区分大小写)
     *
     * @type {string}
     * @memberof AppFormDRUIPart
     */
    @Prop() public parentName!: string;

    /**
     * 关系界面向视图下发指令对象
     *
     * @private
     * @type {Subject<any>}
     * @memberof AppFormDRUIPart
     */
    private formDruipart: Subject<any> = new Subject<any>();

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppFormDRUIPart
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * 监控值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppFormDRUIPart
     */
    @Watch('data')
    onActivedataChange(newVal: any, oldVal: any) {

        if (this.ignorefieldvaluechange) {
            return;
        }
        if (Object.is(newVal, oldVal)) {
            return;
        }
        const newFormData: any = JSON.parse(newVal);
        const oldDormData: any = JSON.parse(oldVal);
        let refreshRefview = false;
        this.hookItems.some((_hookItem: any) => {
            if (!Object.is(newFormData[_hookItem], oldDormData[_hookItem])) {
                refreshRefview = true;
                return refreshRefview;
            }
            return refreshRefview;
        });
        if (refreshRefview) {
            this.refreshDRUIPart();
        }
    }

    /**
     * 是否启用遮罩
     *
     * @type {boolean}
     * @memberof AppFormDRUIPart
     */
    public blockUI: boolean = false;

    /**
     * 是否刷新关系数据
     *
     * @private
     * @type {boolean}
     * @memberof AppFormDRUIPart
     */
    private isRelationalData: boolean = true;

    /**
     * 刷新节点
     *
     * @private
     * @type {string[]}
     * @memberof AppFormDRUIPart
     */
    private hookItems: string[] = [];

    /**
     * 父数据
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    public viewdata: any = {};

    /**
     * 父视图参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    public viewparam: any = {};

    /**
     * 刷新关系页面
     *
     * @private
     * @returns {void}
     * @memberof AppFormDRUIPart
     */
    private refreshDRUIPart(data?:any): void {

        if (Object.is(this.parentdata.SRFPARENTTYPE, 'CUSTOM')) {
            this.isRelationalData = false;
        }
        const formData: any = data?data:JSON.parse(this.data);
        const _paramitem = formData[this.paramItem];
        let viewdata = {srfparentdename:this.parentName,srfparentkey:_paramitem};
        Object.assign(viewdata, this.$viewTool.getIndexViewParam());
        const _parameters: any[] = [...this.$viewTool.getIndexParameters(), ...this.parameters];
        _parameters.forEach((parameter: any) => {
            const { pathName, parameterName }: { pathName: string, parameterName: string } = parameter;
            if (formData[parameterName] && !Object.is(formData[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: formData[parameterName] });
            }
        });
        Object.assign(viewdata, { [this.paramItem]: _paramitem });
        //设置顶层视图唯一标识
        Object.assign(viewdata,this.context);
        this.viewdata = JSON.stringify(viewdata);
        this.viewparam = JSON.stringify(this.viewparams);
        if (this.isRelationalData) {
            if (!_paramitem || _paramitem == null || Object.is(_paramitem, '')) {
                this.blockUIStart();
                return;
            } else {
                this.blockUIStop();
            }
        }
        this.formDruipart.next({action:'load',data:{srfparentdename:this.parentName,srfparentkey:_paramitem}});
    }

    /**
     * vue  生命周期
     *
     * @memberof AppFormDRUIPart
     */
    public created(): void {
        this.hookItems = [...this.refreshitems.split(';')];
        if (!this.formState) {
            return;
        }
        if (!Object.is(this.paramItem, this.parameterName)) {
            this.hookItems.push(this.paramItem);
        }
        this.formStateEvent = this.formState.subscribe(($event: any) => {
            // 表单加载完成
            if (Object.is($event.type, 'load')) {
                this.refreshDRUIPart($event.data);
            }
             // 表单保存之前
            if (Object.is($event.type, 'beforesave')) {
                if(Object.is(this.refviewtype,'DEMEDITVIEW9') || Object.is(this.refviewtype,'DEGRIDVIEW9')){
                    this.formDruipart.next({action:'save',data:$event.data});
                } else {
                    // 不需要保存的界面也要抛出事件，供计数器计算
                    this.$emit('drdatasaved',$event);
                }
            }
            // 表单保存完成
            if (Object.is($event.type, 'save')) {
                this.refreshDRUIPart($event.data);
            }
            // 表单项更新
            if (Object.is($event.type, 'updateformitem')) {
                if (!$event.data) {
                    return;
                }
                let refreshRefview = false;
                Object.keys($event.data).some((name: string) => {
                    const index = this.hookItems.findIndex((_name: string) => Object.is(_name, name));
                    refreshRefview = index !== -1 ? true : false;
                    return refreshRefview;
                });
                if (refreshRefview) {
                    this.refreshDRUIPart();
                }
            }
        });
        this.refreshDRUIPart();
    }

    /**
     * 部件销毁
     *
     * @memberof AppFormDRUIPart
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 开启遮罩
     *
     * @private
     * @memberof AppFormDRUIPart
     */
    private blockUIStart(): void {
        this.blockUI = true;
    }

    /**
     * 关闭遮罩
     *
     * @private
     * @memberof AppFormDRUIPart
     */
    private blockUIStop(): void {
        this.blockUI = false;
    }

     /**
     * 多数据视图加载完成
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public mditemsload(){
        console.log('多数据视图加载完成，触发后续表单项更新');
    }

    /**
     * DEMEDITVIEW9 关系数据保存完成
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public drdatasaved($event:any){
        this.$emit('drdatasaved',$event);
        console.log(this.viewname+'关系数据保存完成');
    }

    /**
     * DEMEDITVIEW9 关系数据值变化
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public drdatachange(){
        console.log('DEMEDITVIEW9 关系数据值变化');
    }

     /**
     * 视图数据变化
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public viewdataschange(){
        console.log('视图数据变化');
    }

    /**
     * 视图加载完成
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public viewload(){
        console.log('视图加载完成');
    }
}
</script>
<style lang = "less">
@import './app-form-druipart.less';
</style>