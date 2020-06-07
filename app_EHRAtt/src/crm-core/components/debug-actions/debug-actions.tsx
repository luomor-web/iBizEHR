import { Vue, Component } from 'vue-property-decorator';
import { StudioActionController } from '@/crm-core/core/base/StudioActionController';
import { Environment } from '@/environments/environment';
import './debug-actions.less';

/**
 * 开发模式控制行为组
 *
 * @export
 * @class DebugActions
 * @extends {Vue}
 */
@Component({})
export class DebugActions extends Vue {

    /**
     * 配置平台操作控制器
     *
     * @type {StudioActionController}
     * @memberof DebugActions
     */
    public sdc: StudioActionController = StudioActionController.getInstance();

    /**
     * 绘制内容
     *
     * @memberof DebugActions
     */
    public render(): any {
        return Environment.devMode ? <div class="debug-actions">
            <div class="actions">
                <button-group vertical>
                    <i-button title="开启配置模式" type={this.sdc.isShowTool ? 'warning' : 'info'} ghost on-click={() => this.sdc.showToolChange()} icon={this.sdc.isShowTool ? 'ios-bug' : 'ios-bug-outline'} ></i-button>
                </button-group>
            </div>
            <div class="show-buttons">
                <div class="button"><i class="ivu-icon ivu-icon-ios-arrow-down" /></div>
            </div>
        </div> : null;
    }

}