import { Http,Util } from '@/utils';
import CheckInLogicBase from './check-in-logic-base';

/**
 * 报到
 *
 * @export
 * @class CheckInLogic
 */
export default class CheckInLogic extends CheckInLogicBase{

    /**
     * Creates an instance of  CheckInLogic
     * 
     * @param {*} [opts={}]
     * @memberof  CheckInLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}