import ViewEngine from './view-engine';

/**
 * 日历导航视图界面引擎
 *
 * @export
 * @class CalendarExpViewEngine
 * @extends {ViewEngine}
 */
export default class CalendarExpViewEngine extends ViewEngine {

    /**
     * 日历导航栏部件
     *
     * @type {*}
     * @memberof CalendarExpViewEngine
     */
    public calendarExpBar: any = null;

    /**
     * Creates an instance of CalendarExpViewEngine.
     * 
     * @memberof CalendarExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof CalendarExpViewEngine
     */
    public init(options: any): void {
        this.calendarExpBar = options.calendarexpbar;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof CalendarExpViewEngine
     */
    public load(): void {
        super.load();
        if (this.getCalendarExpBar() && this.isLoadDefault) {
            const tag = this.getCalendarExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        } else {
            this.isLoadDefault = true;
        }
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof CalendarExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'calendarexpbar')) {
            this.calendarExpBarEvent(eventName, args);

        }
    }

    /**
     * 日历导航事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof CalendarExpViewEngine
     */
    public calendarExpBarEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.view.$emit('viewload', args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.view.$emit('viewdataschange', args);
        }
        if (Object.is(eventName, 'activated')) {
            this.view.$emit('viewdatasactivated', args);
        }
    }

    /**
     * 获取部件对象
     *
     * @returns {*}
     * @memberof CalendarExpViewEngine
     */
    public getCalendarExpBar(): any {
        return this.calendarExpBar;
    }


}