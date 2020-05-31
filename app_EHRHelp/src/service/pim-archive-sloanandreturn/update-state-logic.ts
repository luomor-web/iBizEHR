import { Http,Util } from '@/utils';
import UpdateStateLogicBase from './update-state-logic-base';

/**
 * 更新档案借阅归还状态
 *
 * @export
 * @class UpdateStateLogic
 */
export default class UpdateStateLogic extends UpdateStateLogicBase{

    /**
     * Creates an instance of  UpdateStateLogic
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateStateLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}