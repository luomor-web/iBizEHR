import { Http,Util } from '@/utils';
import CompanyConfirmLogicBase from './company-confirm-logic-base';

/**
 * 公司审批-同意
 *
 * @export
 * @class CompanyConfirmLogic
 */
export default class CompanyConfirmLogic extends CompanyConfirmLogicBase{

    /**
     * Creates an instance of  CompanyConfirmLogic
     * 
     * @param {*} [opts={}]
     * @memberof  CompanyConfirmLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}