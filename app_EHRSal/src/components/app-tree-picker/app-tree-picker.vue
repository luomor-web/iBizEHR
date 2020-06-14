<template>
    <div v-if="refviewname" class="app-tree-picker">
        <Dropdown :visible="visible" trigger="custom" style="left:0px;width: 100%" @on-clickoutside="() => {triggerMenu(false);}" >
          <Input v-model="inputValue" class="tree-input" type="text" :placeholder="placeholder ? placeholder : $t('components.appTreePicker.placeholder')" :disabled="disabled" @on-change="OnInputChange" @on-focus="()=>{triggerMenu();}" >
              <template v-slot:suffix>
                  <i v-if="inputValue && !disabled" class='el-icon-circle-close' @click="onClear"></i>
                  <Icon :type="visible ? 'ios-arrow-up' : 'ios-arrow-down'" class="icon-arrow" @click="() => {triggerMenu();}"></Icon>
              </template>
          </Input>
          <DropdownMenu slot="list">
              <component
                v-if="visible"
                :is="refviewname"
                :viewdata="viewdata"
                :viewparam="viewparam"
                :isShowButton="false"
                :viewDefaultUsage="false"
                @viewdataschange="setValue"
                style="height:100%;">
              </component>
          </DropdownMenu>
        </Dropdown>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';

@Component({
})
export default class AppTreePicker extends Vue {

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppTreePicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppTreePicker
     */
    @Prop() public viewparams!: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppTreePicker
     */
    @Prop() public data!: any;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppTreePicker
     */
    @Prop() public value: any;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppTreePicker
     */
    @Prop({default: false}) public disabled!: boolean;
    
    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppTreePicker
     */
    @Prop() public formState!: Subject<any>

    /**
     * 输入框值
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public inputValue: any = '';

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof SelectType
     */
    protected formStateEvent: Subscription | undefined;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    @Prop() public valueItem?: string;

    /**
     * 关联视图名称
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    @Prop() public refviewname?: string;

    /**
     * 提示信息
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    @Prop() public placeholder?: string;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    @Prop() public name!: string;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof AppTreePicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof AppTreePicker
     */
    @Prop() public localParam!:any;

    /**
     * 是否忽略之变化
     *
     * @type {boolean}
     * @memberof AppTreePicker
     */
    @Prop() public ignorefieldvaluechange!: boolean;

    /**
     * 重置项
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    @Prop() public refreshitems?: string;

    /**
     * 下拉显示控制变量
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public visible: boolean = false;

    /**
     * 视图参数
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public viewparam: any = JSON.stringify(this.viewparams);;
    
    /**
     * 视图上下文
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public viewdata: any = JSON.stringify(this.context);

    /**
     * 输入框change事件
     * 
     * @param $event 事件对象
     * @memberof AppTreePicker
     */
    public OnInputChange($event: any){
        let _viewdata =  Object.assign({ srfnodefilter: this.inputValue }, JSON.parse(this.viewdata)) ;
        this.viewdata = JSON.stringify(_viewdata);
    }

    /**
     * 输入框change事件
     * 
     * @param $event 事件对象
     * @memberof AppTreePicker
     */
    public triggerMenu(visible?: boolean){
        if(this.disabled){
          return;
        }
        if (!visible) {
            this.visible = !this.visible;
        } else {
            this.visible = visible;
        }
    }

    /**
     * 设置视图参数
     *
     * @memberof AppTreePicker
     */
    public setViewParam() {
        if (!this.data) {
            return;
        }
        let arg: any = {};
        // 合并视图上下文参数和视图参数
        let param: any = JSON.parse(JSON.stringify(this.viewparams));
        let context: any = JSON.parse(JSON.stringify(this.context));
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
        this.viewdata = JSON.stringify(context);
        this.viewparam = JSON.stringify(param);
    }

    /**
     * 监控值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTreePicker
     */
    @Watch('data')
    onActivedataChange(newVal: any, oldVal: any) {
        const newFormData: any = JSON.parse(newVal);
        const oldDormData: any = JSON.parse(oldVal);
        this.setViewParam();
        if (!this.refreshitems || this.ignorefieldvaluechange) {
            return;
        }
        if(Object.is(newFormData[this.refreshitems], oldDormData[this.refreshitems])) {
            return;
        }
        this.setValue([{srfmajortext: null, srfkey: null}]);
    }

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTreePicker
     */
    @Watch('value')
    public onValueChange(newVal: any, oldVal: any) {
        this.inputValue = newVal;
    }

    /**
     * 生命周期
     *
     * @memberof AppTreePicker
     */
    public created() {
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ tag, action, data }) => {
                if (Object.is('load', action)) {
                    this.setViewParam();
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppTreePicker
     */
    public destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 设置值
     *
     * @param {*} item
     * @memberof AppTreePicker
     */
    public setValue(item: any) {
        this.visible = false;
        if (this.valueItem) {
            this.$emit('formitemvaluechange', { name: this.valueItem, value: item[0].srfkey });
        }
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: item[0].srfmajortext });
        }
    }

    /**
     * 清除
     */
    public onClear($event: any): void {
        if (this.valueItem) {
            this.$emit('formitemvaluechange', { name: this.valueItem, value: '' });
        }
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: '' });
        }
        this.$forceUpdate();
    }

}
</script>

<style lang='less'>
@import './app-tree-picker.less';
</style>