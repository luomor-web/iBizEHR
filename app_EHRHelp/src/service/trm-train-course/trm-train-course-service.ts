import { Http,Util } from '@/utils';
import TrmTrainCourseServiceBase from './trm-train-course-service-base';


/**
 * 培训课程服务对象
 *
 * @export
 * @class TrmTrainCourseService
 * @extends {TrmTrainCourseServiceBase}
 */
export default class TrmTrainCourseService extends TrmTrainCourseServiceBase {

    /**
     * Creates an instance of  TrmTrainCourseService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainCourseService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}