/**
 * MPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class MPickupViewpickupviewpanelModel
 */
export default class MPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof MPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'orgid',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'xh',
      },
      {
        name: 'createman',
      },
      {
        name: 'ormxmbqname',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'ormxmbq',
        prop: 'ormxmbqid',
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