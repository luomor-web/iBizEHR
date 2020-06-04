<template>
  <radio-group class="app-radio-group" v-model="value" >                 
    <radio v-for="(_item,index) in items" :key = "index" :label="_item.value" :disabled="isDisabled || _item.disabled">
        <span>{{Object.is(codelistType,'STATIC') ? $t('codelist.'+tag+'.'+_item.value) : _item.text}}</span>
    </radio>
  </radio-group>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop, Model } from 'vue-property-decorator';
import CodeListService from "@service/app/codelist-service";

@Component({})
export default class AppRadioGroup extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof AppRadioGroup
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 双向绑定值
     *
     * @type {*}
     * @memberof AppRadioGroup
     */
    @Model('change') item?: any;

    /**
     * 获取值
     *
     * @memberof AppRadioGroup
     */
    get value() {
        return this.item;
    }

    /**
     * 设置值
     *
     * @memberof AppRadioGroup
     */
    set value(val: any) {
        this.$emit('change', val);
    }

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof AppRadioGroup
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof AppRadioGroup
     */
    @Prop() public codelistType?: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppRadioGroup
     */
    @Prop() public disabled?: boolean;

    /**
     * 属性名称
     *
     * @type {string}
     * @memberof AppRadioGroup
     */
    @Prop() name?: string;

    /**
     * 是否禁用
     *
     * @readonly
     * @memberof AppRadioGroup
     */
    get isDisabled() {
        if (this.disabled) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof AppRadioGroup
     */
    public items: any[] = [];

    /**
     * vue  生命周期
     *
     * @memberof AppRadioGroup
     */
    public created() {
        if(this.tag && this.codelistType == 'STATIC'){
            this.items  = this.$store.getters.getCodeListItems(this.tag);
        }else if(this.tag && this.codelistType == 'DYNAMIC'){
            this.codeListService.getItems(this.tag).then((data:any)=>{
                this.items = data;
            }).catch((data:any)=>{
                console.log(`----${this.tag}----代码表不存在！`);
            })
        }
    }
}
</script>
<style lang="less">
@import './app-radio-group.less';
</style>