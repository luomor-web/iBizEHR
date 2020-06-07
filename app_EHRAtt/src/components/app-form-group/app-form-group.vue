<template>
    <div class="app-form-group">
        <div v-if="uiStyle=='STYLE2'">
            <app-form-group2
                :caption="caption"
                :uiStyle="uiStyle"
                :layoutType="layoutType"
                :isShowCaption="isShowCaption"
                :uiActionGroup="uiActionGroup"
                :titleBarCloseMode="titleBarCloseMode">
                   <slot></slot>
                </app-form-group2>
        </div>
        <div v-else>
            <card v-if="isShowCaption === true" :bordered="false" :dis-hover="true" :class="classes">
                <p class='' slot='title'>
                     <icon v-if="titleBarCloseMode !== 0" :type="collapseContant ? 'ios-arrow-dropright-circle' : 'ios-arrow-dropdown-circle'"
                    @click="clickCollapse"></icon>
                    <span :class="titleClass">{{caption}}</span>
                </p>
                <template v-if="uiActionGroup">
                    <a slot='extra'>
                        <template v-if="uiActionGroup.extractMode && Object.is(uiActionGroup.extractMode, 'ITEMS')">
                            <dropdown :transfer="true" trigger='click'>
                            <a href='javascript:void(0)'>
                                {{uiActionGroup.caption}}
                            </a>
                            <dropdown-menu slot='list' v-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)">
                                <dropdown-item v-for="(detail,index) in (uiActionGroup.details)" :key="index" :name="detail.name">
                                    <span class='item' @click="doUIAction($event, detail)">
                                        <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                             <i :class="detail.icon" ></i>
                                        </template>
                                        <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                            <div v-if="detail.img && !Object.is(detail.img, '')">
                                                <img :src="detail.img" />
                                            </div>
                                        </template>
                                        &nbsp;
                                        <span>
                                            <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                            </template>
                                            <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                {{detail.caption}}
                                            </template>
                                        </span>
                                    </span>
                                </dropdown-item>
                            </dropdown-menu>
                        </dropdown>
                        </template>
                        <template v-if="!(uiActionGroup.extractMode && Object.is(uiActionGroup.extractMode, 'ITEMS'))">
                             <span class='item-extract-mode'>
                                <template v-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)">
                                    <div v-for="(detail,index) in uiActionGroup.details" :key="index">
                                        <span class='item' @click="doUIAction($event, detail)">
                                        <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                             <i :class="detail.icon" ></i>
                                        </template>
                                        <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                            <div v-if="detail.img && !Object.is(detail.img, '')">
                                                <img :src="detail.img" />
                                            </div>
                                        </template>
                                        &nbsp;
                                        <span>
                                            <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                            </template>
                                            <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                {{detail.caption}}
                                            </template>
                                        </span>
                                    </span>
                                    </div>
                                </template>
                            </span>
                        </template>
                    </a >
                </template>
                <div v-if="Object.is(layoutType, 'FLEX')">
                    <slot></slot>
                </div>
                <div v-if="!Object.is(layoutType, 'FLEX')">
                    <row :gutter="10"><slot></slot></row>
                </div>
            </card>
            <row v-if="isShowCaption === false" :class="classes">
               <slot></slot>
            </row>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppFormGroup extends Vue {

    /**
     * 标题
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public caption?: string;

    /**
     * 内置界面样式
     * 
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public uiStyle?: string;

    /**
     * 布局模式
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public layoutType?: string;

    /**
     * 标题样式
     *
     * @type {string}
     * @memberof AppFormGroup
     */    
    @Prop() public titleStyle?:string;

    /**
     * 分组图标
     *
     * @type {string}
     * @memberof AppFormGroup
     */ 
    @Prop() public iconInfo?:any;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: true }) public isShowCaption!: boolean;

    /**
     * 信息面板模式
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public isInfoGroupMode!: boolean;

    /**
     * 界面行为组
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public uiActionGroup?: any;

    /**
     * 标题栏关闭模式
     * 0: 不支持关闭
     * 1: 默认打开
     * 2： 默认关闭
     *
     * @type {(number | 0 | 1 | 2)} 
     * @memberof AppFormGroup
     */
    @Prop({ default: 0 }) public titleBarCloseMode!: number | 0 | 1 | 2;

    /**
     * 收缩内容
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    public collapseContant: boolean = false;

    /**
     * 计算样式
     *
     * @readonly
     * @type {string[]}
     * @memberof AppFormGroup
     */
    get classes(): string[] {
        return [
            'app-form-group',
            this.isShowCaption && this.collapseContant ? 'app-group-collapse-contant' : '',
            this.isInfoGroupMode ? 'app-info-group-mode' : '',
            Object.is(this.layoutType, 'FLEX') ? 'app-group-flex': ''
        ];
    }

    /**
     * 标题样式
     *
     * @readonly
     * @type {string}
     * @memberof AppFormGroup
     */
    get titleClass():string{
        return this.titleStyle?this.titleStyle:'';
    }

    /**
     * vue 生命周期
     *
     * @memberof AppFormGroup
     */
    public created() {
        this.collapseContant = this.titleBarCloseMode === 2 ? true : false;
    }

    /**
     * 触发收缩
     *
     * @memberof AppFormGroup
     */
    public clickCollapse(): void {
        this.collapseContant = !this.collapseContant;
    }

    /**
     * 执行界面行
     *
     * @param {*} $event
     * @memberof AppFormGroup
     */
    public doUIAction($event: any, item: any): void {
        this.$emit('groupuiactionclick', { event: $event, item: item });
    }
}
</script>
<style lang='less'>
@import './app-form-group.less';
</style>