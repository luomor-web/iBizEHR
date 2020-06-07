import { FormDetailModel } from './form-detail';

/**
 * 用户控件模型
 *
 * @export
 * @class FormUserControlModel
 * @extends {FormDetailModel}
 */
export class FormUserControlModel extends FormDetailModel {


    constructor(otps:any = {}) {
        super(otps);
    }
}