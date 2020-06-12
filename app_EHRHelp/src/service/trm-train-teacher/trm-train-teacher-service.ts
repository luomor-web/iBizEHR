import { Http,Util } from '@/utils';
import TrmTrainTeacherServiceBase from './trm-train-teacher-service-base';


/**
 * 培训讲师服务对象
 *
 * @export
 * @class TrmTrainTeacherService
 * @extends {TrmTrainTeacherServiceBase}
 */
export default class TrmTrainTeacherService extends TrmTrainTeacherServiceBase {

    /**
     * Creates an instance of  TrmTrainTeacherService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainTeacherService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}