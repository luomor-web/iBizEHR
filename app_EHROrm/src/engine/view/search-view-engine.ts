import ViewEngine from './view-engine';

/**
 * 搜索视图引擎
 *
 * @export
 * @class SearchViewEngine
 * @extends {ViewEngine}
 */
export class SearchViewEngine extends ViewEngine {

    /**
     * 表单部件
     *
     * @protected
     * @type {*}
     * @memberof SearchViewEngine
     */
    protected searchForm: any;

    /**
     * 初始化
     *
     * @param {*} options
     * @memberof SearchViewEngine
     */
    public init(options: any): void {
        this.searchForm = options.searchform;
        super.init(options);

    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof SearchViewEngine
     */
    public load(opts: any = {}): void {
        super.load(opts);
        if (this.getSearchForm()) {
            const tag = this.getSearchForm().name;
            this.setViewState2({ tag: tag, action: 'loaddraft', viewdata: this.view.viewparams });
        }
    }

    /**
     * 事件处理
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof SearchViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'searchform')) {
            this.searchFormEvent(eventName, args);
        }
    }

    /**
     * 搜索表单事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof SearchViewEngine
     */
    public searchFormEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'load')) {
            this.onSearchFormLoad(args);
        }
    }

    /**
     * 搜索表单加载完成
     *
     * @param {*} [args={}]
     * @memberof SearchViewEngine
     */
    public onSearchFormLoad(args: any = {}): void {
    }

    /**
     * 数据部件加载之前
     *
     * @param {*} [arg={}]
     * @memberof SearchViewEngine
     */
    public dataCtrlBeforeLoad(arg: any = {}): void {
        if (this.view.viewparams && Object.keys(this.view.viewparams).length > 0) {
            Object.assign(arg, this.view.viewparams);
        }
        if (this.getSearchForm()) {
            Object.assign(arg, this.getSearchForm().getData());
        }
        if (this.view && !this.view.isExpandSearchForm) {
            Object.assign(arg, { query: this.view.query });
        }
    }


    /**
     * 获取搜索表单
     *
     * @returns {*}
     * @memberof SearchViewEngine
     */
    public getSearchForm(): any {
        return this.searchForm;
    }
}