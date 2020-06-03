import { Component, Vue, Prop } from 'vue-property-decorator';
import { StudioActionController } from '@/crm-core/core/base/StudioActionController';
import { Environment } from '@/environments/environment';
import './view-config-actions.less';

/**
 * 视图快捷配置
 *
 * @export
 * @class ViewConfigActions
 * @extends {Vue}
 */
@Component({})
export class ViewConfigActions extends Vue {

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof ViewConfigActions
     */
    @Prop({ default: () => { } })
    public viewName!: string;

    /**
     * 视图标题
     *
     * @type {string}
     * @memberof ViewConfigActions
     */
    @Prop({ default: '' })
    public viewTitle!: string;

    /**
     * 视图配置信息
     *
     * @protected
     * @type {*}
     * @memberof ViewConfigActions
     */
    protected config: any = {};

    /**
     * 配置平台操作控制器
     *
     * @type {StudioActionController}
     * @memberof ViewConfigActions
     */
    public sdc: StudioActionController = StudioActionController.getInstance();

    /**
     * 触发配置
     *
     * @protected
     * @memberof AppLayout
     */
    protected configView(): void {
        this.sdc.openStudioConfigView(this.viewName);
    }

    /**
     * 新建issues
     *
     * @protected
     * @memberof AppLayout
     */
    protected createIssues(): void {
        this.sdc.createdIssues(this.viewName);
    }

    /**
     * 组件创建完毕
     *
     * @protected
     * @returns {Promise<void>}
     * @memberof ViewConfigActions
     */
    protected async created(): Promise<void> {
        if (Environment.devMode) {
            this.config = await this.sdc.getConfig(this.viewName);
        }
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof ViewConfigActions
     */
    public render(): any {
        return Environment.devMode ? <div v-show={this.sdc.isShowTool} class="studio-config-container">
            <div class="title">
                <tooltip content={this.config.memo || '无备注'} placement="bottom-end">
                    <icon type="ios-bulb-outline" />
                </tooltip>
                {this.viewTitle}
            </div>
            <div class="actions">
                <button-group>
                    <i-button title="进入当前视图配置界面" type="text" icon="ios-hammer" ghost on-click={() => this.configView()}>配置</i-button>
                    <i-button title="建立当前界面的issues" type="text" icon="ios-browsers" ghost on-click={() => this.createIssues()}>新建issues</i-button>
                </button-group>
            </div>
        </div> : null;
    }
}