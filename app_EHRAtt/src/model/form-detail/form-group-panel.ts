import { FormDetailModel } from './form-detail';

/**
 * 分组面板模型
 *
 * @export
 * @class FormGroupPanelModel
 * @extends {FormDetailModel}
 */
export class FormGroupPanelModel extends FormDetailModel {

    /**
     * 实体界面行为组
     *
     * @type {*}
     * @memberof FormGroupPanelModel
     */
    public uiActionGroup: any = {};

    /**
     * Creates an instance of FormGroupPanelModel.
     * 创建 FormGroupPanelModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof FormGroupPanelModel
     */
    constructor(opts: any = {}) {
        super(opts);
        Object.assign(this.uiActionGroup, opts.uiActionGroup);
    }
}