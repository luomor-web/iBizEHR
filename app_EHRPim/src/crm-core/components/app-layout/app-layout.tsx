import { Vue, Component, Emit, Prop } from 'vue-property-decorator';
import { ViewConfigActions } from '../view-config-actions/view-config-actions';
import './app-layout.less';

/**
 * 应用基础布局
 *
 * @export
 * @class AppLayout
 * @extends {Vue}
 */
@Component({
    components: {
        'view-config-actions': ViewConfigActions
    }
})
export class AppLayout extends Vue {

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof AppLayout
     */
    @Prop({ default: () => { } })
    public viewName!: string;

    /**
     * 视图标题
     *
     * @type {string}
     * @memberof AppLayout
     */
    @Prop({ default: '' })
    public viewTitle!: string;

    /**
     * 额外样式名称
     *
     * @type {{[key: string]: boolean}}
     * @memberof AppLayout
     */
    @Prop({ default: () => { } })
    public className!: { [key: string]: boolean };

    /**
     * 布局呈现模式
     *
     * @type {string}
     * @memberof AppLayout
     */
    @Prop({ default: 'DEFAULT' })
    public layoutMode!: string;

    /**
     * 是否展示用户信息
     *
     * @type {boolean}
     * @memberof AppLayout
     */
    @Prop({ default: true })
    public isShowUserInfo!: boolean;

    /**
     * 视图呈现模式
     *
     * @type {string}
     * @memberof AppLayout
     */
    @Prop({ default: 'DEFAULT' })
    public openMode!: string;

    /**
     * 是否显示标题栏
     *
     * @type {boolean}
     * @memberof AppLayout
     */
    @Prop({ default: true })
    public isShowCaptionBar!: boolean;

    /**
     * 是否显示工具栏区域
     *
     * @type {boolean}
     * @memberof AppLayout
     */
    @Prop({ default: true })
    public isShowToolbar!: boolean;

    /**
     * 组件挂载完毕
     *
     * @memberof AppLayout
     */
    @Emit('mounted')
    public mounted(): void { }

    /**
     * 视图关闭
     *
     * @memberof AppLayout
     */
    @Emit('close-view')
    public closeView(): any {
        return [];
    }

    /**
     * 绘制布局内容
     *
     * @returns {*}
     * @memberof AppLayout
     */
    public render(): any {
        if (Object.is(this.layoutMode, 'VIEW') && Object.is(this.openMode, 'DEFAULT')) {
            Object.assign(this.className, { 'crm-app-view': true, 'no-caption-bar':  (!this.isShowCaptionBar && !this.isShowToolbar) });
            return <div class={this.className}>
                 {(!this.isShowCaptionBar && !this.isShowToolbar) ? null : <div class="crm-app-view-header-wrapper">
                    {this.isShowCaptionBar ? <div class="crm-app-view-header-left-wrapper">
                        {this.$slots.headerLeft}
                    </div> : null}
                    {this.isShowToolbar ? <div class="crm-app-view-header-right-wrapper">
                        {this.$slots.headerRight}
                    </div> : null}
                </div>}
                <div class="crm-app-view-content-wrapper">
                    <view-config-actions viewName={this.viewName} viewTitle={this.viewTitle}/>
                    {this.$slots.content}
                </div>
            </div>;
        }
        Object.assign(this.className, { 'crm-app-layout': true, 'no-caption-bar': !this.isShowCaptionBar });
        return <div class={this.className}>
            <div class="crm-app-header-container">
                <div class="crm-app-header-background"></div>
                <div class="crm-app-header">
                    <div class="crm-app-header-left-container">{this.$slots.headerLeft}</div>
                    <div class="crm-app-header-right-container">{this.$slots.headerRight}</div>
                </div>
                {this.isShowUserInfo ? <div class="crm-user-info-container">
                    <app-user-info />
                </div> : null}
                {Object.is(this.openMode, 'MODAL') ? <div class="crm-modal-close" on-click={() => this.closeView()}>
                    <i class="ivu-icon ivu-icon-md-close" />
                </div> : null}
            </div>
            <div class="crm-app-content-container">
                <view-config-actions viewName={this.viewName} viewTitle={this.viewTitle}/>
                {this.$slots.content}
            </div>
        </div>;
    }

}