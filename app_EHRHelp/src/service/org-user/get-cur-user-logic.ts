import { Http,Util } from '@/utils';
import GetCurUserLogicBase from './get-cur-user-logic-base';

/**
 * 获取当前用户
 *
 * @export
 * @class GetCurUserLogic
 */
export default class GetCurUserLogic extends GetCurUserLogicBase{

    /**
     * Creates an instance of  GetCurUserLogic
     * 
     * @param {*} [opts={}]
     * @memberof  GetCurUserLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}