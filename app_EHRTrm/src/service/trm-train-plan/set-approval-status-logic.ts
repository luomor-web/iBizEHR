import { Http,Util } from '@/utils';
import SetApprovalStatusLogicBase from './set-approval-status-logic-base';

/**
 * 设置审核通过状态
 *
 * @export
 * @class SetApprovalStatusLogic
 */
export default class SetApprovalStatusLogic extends SetApprovalStatusLogicBase{

    /**
     * Creates an instance of  SetApprovalStatusLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetApprovalStatusLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}