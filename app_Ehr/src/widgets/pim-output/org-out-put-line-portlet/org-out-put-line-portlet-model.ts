/**
 * OrgOutPutLine 部件模型
 *
 * @export
 * @class OrgOutPutLineModel
 */
export default class OrgOutPutLineModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof OrgOutPutLineModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'yd',
      },
      {
        name: 'createman',
      },
      {
        name: 'pimoutputname',
      },
      {
        name: 'pimoutput',
        prop: 'pimoutputid',
      },
      {
        name: 'updateman',
      },
      {
        name: 'nd',
      },
      {
        name: 'output',
      },
      {
        name: 'enable',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'zzxs',
      },
      {
        name: 'orgcode',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgid',
      },
    ]
  }


}
