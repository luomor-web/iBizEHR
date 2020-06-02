/**
 * ORMORGBMTree 部件模型
 *
 * @export
 * @class ORMORGBMTreeModel
 */
export default class ORMORGBMTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof ORMORGBMTreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'updatedate',
      },
      {
        name: 'attendancemreport',
        prop: 'attendancemreportid',
      },
      {
        name: 'attendancemreportname',
      },
      {
        name: 'createman',
      },
      {
        name: 'orgid',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'yf',
      },
      {
        name: 'enable',
      },
      {
        name: 'nd',
      },
      {
        name: 'zt',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'pimpersonname',
      },
      {
        name: 'pimpersonid',
      },
      {
        name: 'attendencesetupname',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'attendencesetupid',
      },
    ]
  }


}