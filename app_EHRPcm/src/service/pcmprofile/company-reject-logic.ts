import { Http,Util } from '@/utils';
import CompanyRejectLogicBase from './company-reject-logic-base';

/**
 * 公司审批-拒绝
 *
 * @export
 * @class CompanyRejectLogic
 */
export default class CompanyRejectLogic extends CompanyRejectLogicBase{

    /**
     * Creates an instance of  CompanyRejectLogic
     * 
     * @param {*} [opts={}]
     * @memberof  CompanyRejectLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}