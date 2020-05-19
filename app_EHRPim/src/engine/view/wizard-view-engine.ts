import ViewEngine from './view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class GridViewEngine
 */
export default class WizardViewEngine extends ViewEngine {

    /**
     * 向导面板部件
     *
     * @protected
     * @type {*}
     * @memberof EditViewEngine
     */
    protected wizardpanel: any;

    /**
     * 初始化编辑视图引擎
     *
     * @param {*} [options={}]
     * @memberof EditViewEngine
     */
    public init(options: any = {}): void {
        this.wizardpanel = options.wizardpanel;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof EditViewEngine
     */
    public load(opts: any = {}): void {
        super.load(opts);
        if (this.getWizardPanel()) {
            const tag = this.getWizardPanel().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.context });
        }
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof ViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'wizardpanel')) {
            this.wizardPanelEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {any[]} args
     * @memberof MDViewEngine
     */
    public wizardPanelEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'finish')) {
            this.onfinish(args);
        }
    }

    /**
     * 完成
     *
     * @param {*} args
     * @memberof WizardViewEngine
     */
    public onfinish(args: any): void {
        this.view.$emit('viewdataschange', [args]);
        this.view.$emit('close', null);
    }

    /**
     * 获取向导面板
     *
     * @returns {*}
     * @memberof WizardViewEngine
     */
    public getWizardPanel(): any {
        return this.wizardpanel;
    }
}