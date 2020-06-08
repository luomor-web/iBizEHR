import Vue from 'vue';
import { Http } from '@/utils';
import { Environment } from '@/environments/environment';
import { on } from '@/utils/dom/dom';

/**
 * Studio Debug工具类
 *
 * @export
 * @class StudioActionUtil
 */
export class StudioActionUtil {
    /**
     * 唯一实例
     *
     * @private
     * @static
     * @type {StudioActionUtil}
     * @memberof StudioActionUtil
     */
    private static readonly instance: StudioActionUtil = new StudioActionUtil();

    /**
     * 是否启用
     *
     * @protected
     * @type {boolean}
     * @memberof StudioActionUtil
     */
    protected isEnable: boolean = Environment.devMode;

    /**
     * 请求对象
     *
     * @protected
     * @type {Http}
     * @memberof StudioActionUtil
     */
    protected http: Http = Http.getInstance();

    /**
     * 配置信息
     *
     * @protected
     * @type {*}
     * @memberof StudioActionUtil
     */
    protected config: any = null;

    /**
     * 配置平台界面
     *
     * @protected
     * @type {Window}
     * @memberof StudioActionUtil
     */
    protected studioWin: Window | null = null;

    /**
     * 是否显示开发配置工具栏
     *
     * @type {boolean}
     * @memberof StudioActionUtil
     */
    public isShowTool: boolean = false;

    /**
     * Creates an instance of StudioActionUtil.
     * @memberof StudioActionUtil
     */
    constructor() {
        if (StudioActionUtil.instance) {
            return StudioActionUtil.instance;
        }
        if (Environment.devMode) {
            on(window, 'keydown', (e: KeyboardEvent) => {
                if ((e.ctrlKey || e.metaKey) && e.keyCode === 123) {
                    this.showToolChange();
                }
            });
        }
    }

    /**
     * 为当前视图建立issues
     *
     * @param {string} viewName
     * @returns {Promise<void>}
     * @memberof StudioActionUtil
     */
    public async createdIssues(viewName: string): Promise<void> {
        const config: any = await this.getConfig(viewName);
        if (config) {
            const context: string = `视图模块：${config.viewmodule}\n视图标识：${config.viewname}\n视图类型：${config.viewtype}\n`;
            window.open(`${Environment.ProjectUrl}/issues/`, '_blank');
        }
    }

    /**
     * 打开Studio配置界面
     *
     * @param {string} viewName
     * @returns {Promise<void>}
     * @memberof StudioActionUtil
     */
    public async openStudioConfigView(viewName: string): Promise<void> {
        const config: any = await this.getConfig(viewName);
        if (config) {
            const params: any = {
                "appType": "APPSTUDIO",
                "appKey": Environment.AppId,
                "dataType": "AppDesign_PSAppViewDesignRedirectView",
                "srfkey": config.viewtag
            };
            if (this.studioWin && this.studioWin.closed === false) {
                this.studioWin.postMessage({
                    type: 'OpenView',
                    params
                }, '*');
                Vue.prototype.$message.warning('请在已打开的配置平台查看!');
            } else {
                this.studioWin = window.open(`${Environment.StudioUrl}?ov=${encodeURIComponent(JSON.stringify(params))}#/common_slnindex/srfkeys=${Environment.SlnId}/sysdesign_psdevslnsysmodeltreeexpview/srfkey=${Environment.SysId}`, '_blank');
            }
        }
    }

    /**
     * 获取视图配置参数
     *
     * @protected
     * @param {string} viewName
     * @returns {Promise<any>}
     * @memberof StudioActionUtil
     */
    protected async getConfig(viewName: string): Promise<any> {
        if (!this.config) {
            await this.loadConfig();
        }
        return this.config[viewName];
    }

    /**
     * 加载配置信息
     *
     * @protected
     * @returns {Promise<void>}
     * @memberof StudioActionUtil
     */
    protected async loadConfig(): Promise<void> {
        const response: any = await this.http.get('./assets/json/view-config.json');
        if (response && response.status === 200 && response.data) {
            this.config = response.data
        } else {
            console.warn('Studio操作控制器，视图参数信息加载失败!');
        }
    }

    /**
     * 展示配置工具栏状态变更
     *
     * @memberof StudioActionController
     */
    public showToolChange(): void {
        this.isShowTool = !this.isShowTool;
    }

    /**
     * 获取实例
     *
     * @static
     * @returns {StudioActionUtil}
     * @memberof StudioActionUtil
     */
    public static getInstance(): StudioActionUtil {
        return this.instance;
    }

}