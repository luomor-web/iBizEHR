import { Http,Util } from '@/utils';
import SetRejectStatusLogicBase from './set-reject-status-logic-base';

/**
 * 设置审核不通过状态
 *
 * @export
 * @class SetRejectStatusLogic
 */
export default class SetRejectStatusLogic extends SetRejectStatusLogicBase{

    /**
     * Creates an instance of  SetRejectStatusLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetRejectStatusLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}