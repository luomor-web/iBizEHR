import { Http,Util } from '@/utils';
import UnCheckInLogicBase from './un-check-in-logic-base';

/**
 * 逾期未报到
 *
 * @export
 * @class UnCheckInLogic
 */
export default class UnCheckInLogic extends UnCheckInLogicBase{

    /**
     * Creates an instance of  UnCheckInLogic
     * 
     * @param {*} [opts={}]
     * @memberof  UnCheckInLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}