import ViewEngine from './view-engine';

/**
 * 编辑视图引擎
 *
 * @export
 * @class EditViewEngine
 * @extends {ViewEngine}
 */
export default class EditViewEngine extends ViewEngine {

    /**
     * 表单部件
     *
     * @protected
     * @type {*}
     * @memberof EditViewEngine
     */
    protected form: any;

    /**
     * 父健为当前健
     *
     * @protected
     * @type {string}
     * @memberof EditViewEngine
     */
    protected p2k: string = '';

    /**
     * 初始化编辑视图引擎
     *
     * @param {*} [options={}]
     * @memberof EditViewEngine
     */
    public init(options: any = {}): void {
        this.form = options.form;
        this.p2k = options.p2k;
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
        if (this.getForm() && this.isLoadDefault) {
            const tag = this.getForm().name;
            let action: string = '';
            if (this.keyPSDEField && this.view.context[this.keyPSDEField] && !Object.is(this.view.context[this.keyPSDEField], '')) {
                action = 'load';
            } else {
                action = 'loaddraft';
            }
            this.setViewState2({ tag: tag, action: action, viewdata: this.view.viewparams });
        }
        this.isLoadDefault = true;
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof EditViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'form')) {
            this.formEvent(eventName, args);
        }
    }

    /**
     * 表单事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof EditViewEngine
     */
    public formEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.onFormLoad(args);
        }
        if (Object.is(eventName, 'save')) {
            this.onFormSave(args);
        }
        if (Object.is(eventName, 'remove')) {
            this.onFormRemove(args);
        }
    }

    /**
     * 表单加载完成
     *
     * @param {*} args
     * @memberof EditViewEngine
     */
    public onFormLoad(arg: any): void {
        this.view.model.dataInfo = Object.is(arg.srfuf, '1') ? arg.srfmajortext : '新建';

        this.setTabCaption(this.view.model.dataInfo);
        const newdata: boolean = !Object.is(arg.srfuf, '1');
        this.calcToolbarItemState(newdata);
    }

    /**
     * 表单保存完成
     *
     * @param {*} args
     * @memberof EditViewEngine
     */
    public onFormSave(arg: any): void {
        this.view.model.dataInfo = Object.is(arg.srfuf, '1') ? arg.srfmajortext : '新建';

        this.setTabCaption(this.view.model.dataInfo);
        const newdata: boolean = !Object.is(arg.srfuf, '1');
        this.calcToolbarItemState(newdata);
        this.view.$emit('save',arg);
        this.view.$emit('viewdataschange',JSON.stringify({action:'save',status:'success',data:arg}));
    }

    /**
     * 表单删除完成
     *
     * @param {*} args
     * @memberof EditViewEngine
     */
    public onFormRemove(arg: any): void {
        this.view.$emit('remove',arg);
        this.view.$emit('viewdataschange',JSON.stringify({action:'remove',status:'success',data:arg}));
    }

    /**
     * 处理实体界面行为
     *
     * @param {string} tag
     * @param {string} [actionmode]
     * @returns {void}
     * @memberof EditViewEngine
     */
    public doSysUIAction(tag: string, actionmode?: string): void {
        // if (Object.is(tag, 'Help')) {
        //     this.doHelp();
        //     return;
        // }
        // if (Object.is(tag, 'SaveAndStart')) {
        //     this.doSaveAndStart();
        //     return;
        // }
        // if (Object.is(tag, 'SaveAndExit')) {
        //     this.doSaveAndExit();
        //     return;
        // }
        // if (Object.is(tag, 'SaveAndNew')) {
        //     this.doSaveAndNew();
        //     return;
        // }
        if (Object.is(tag, 'Save')) {
            this.doSave();
            return;
        }
        // if (Object.is(tag, 'Print')) {
        //     this.doPrint();
        //     return;
        // }
        // if (Object.is(tag, 'Copy')) {
        //     this.doCopy();
        //     return;
        // }
        // if (Object.is(tag, 'RemoveAndExit')) {
        //     this.doRemoveAndExit();
        //     return;
        // }
        // if (Object.is(tag, 'Refresh')) {
        //     this.doRefresh();
        //     return;
        // }
        // if (Object.is(tag, 'New')) {
        //     this.doNew();
        //     return;
        // }
        // if (Object.is(tag, 'FirstRecord')) {
        //     this.doMoveToRecord('first');
        //     return;
        // }
        // if (Object.is(tag, 'PrevRecord')) {
        //     this.doMoveToRecord('prev');
        //     return;
        // }
        // if (Object.is(tag, 'NextRecord')) {
        //     this.doMoveToRecord('next');
        //     return;
        // }
        // if (Object.is(tag, 'LastRecord')) {
        //     this.doMoveToRecord('last');
        //     return;
        // }
        // if (Object.is(tag, 'Exit') || Object.is(tag, 'Close')) {
        //     this.doExit();
        //     return;
        // }
        super.doSysUIAction(tag, actionmode);
    }

    /**
     * 编辑界面_保存操作
     * 
     * @memberof IBizEditViewController
     */
    public doSave(): void {
        // this.afterformsaveaction = '';
        this.saveData({});
    }

    /**
     * 保存视图数据
     *
     * @param {*} [arg={}]
     * @memberof EditViewEngine
     */
    public saveData(arg: any = {}): void {
        if (this.getForm()) {
            const tag = this.getForm().name;
            this.setViewState2({ tag: tag, action: 'save', viewdata: arg });
        }
    }

    /**
     * 获取表单对象
     *
     * @returns {*}
     * @memberof EditViewEngine
     */
    public getForm(): any {
        return this.form;
    }

    /**
     * 设置分页标题
     *
     * @memberof EditViewEngine
     */
    public setTabCaption(info: string): void {
        let viewdata: any = this.view.model;
        if (viewdata  && info && !Object.is(info, '') && this.view.$tabPageExp && (viewdata.srfTitle.indexOf(" - ") === -1)) {
            this.view.$tabPageExp.setCurPageCaption(viewdata.srfCaption, viewdata.srfTitle, info);
            this.view.model.srfTitle = `${this.view.$t(viewdata.srfTitle)} - ${viewdata.dataInfo}`;
        }
    }

}