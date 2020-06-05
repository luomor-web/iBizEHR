import { Http,Util } from '@/utils';
import SetRejectLogicBase from './set-reject-logic-base';

/**
 * 审核不通过逻辑
 *
 * @export
 * @class SetRejectLogic
 */
export default class SetRejectLogic extends SetRejectLogicBase{

    /**
     * Creates an instance of  SetRejectLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetRejectLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}