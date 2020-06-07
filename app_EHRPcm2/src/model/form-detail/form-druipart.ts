import { FormDetailModel } from './form-detail';

/**
 * 数据关系界面模型
 *
 * @export
 * @class FormDRUIPartModel
 * @extends {FormDetailModel}
 */
export class FormDRUIPartModel extends FormDetailModel {

    /**
     * 关系视图类型
     *
     * @type {string}
     * @memberof FormDRUIPartModel
     */
    public refviewtype: string = '';

    /**
     * 是否正在保存
     *
     * @type {boolean}
     * @memberof FormDRUIPartModel
     */
    public isSaving: boolean = false;

    /**
     * 关系页面是否数据变更
     *
     * @type {boolean}
     * @memberof FormDRUIPartModel
     */
    public refViewDirty: boolean = false;

    /**
     * 是否保存成功
     *
     * @type {boolean}
     * @memberof FormDRUIPartModel
     */
    public isSaveSuccess: boolean = false;

    /**
     * 保存关系视图
     *
     * @type {number}
     * @memberof FormDRUIPartModel
     */
    public saveRefView: number = 0;

    /**
     * Creates an instance of FormDRUIPartModel.
     * 
     * @param {*} [opts={}]
     * @memberof FormDRUIPartModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.refviewtype = opts.refviewtype;
    }

    /**
     * 关系页数据保存结果，判断主表单是否保存
     *
     * @param {boolean} $event 保存结果
     * @memberof FormDRUIPartModel
     */
    public onDrDataSaved($event: boolean): void {
        this.isSaving = false;
        if ($event) {
            this.refViewDirty = false;
            this.isSaveSuccess = true;
        }

        // 判断表单的所有关系项是否都保存完成
        if ($event && this.form && this.form.DRUIPartSaveResult()) {
            this.form.save();
        }
    }
}