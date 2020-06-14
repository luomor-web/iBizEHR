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
        name: 'createdate',
      },
      {
        name: 'saltype',
      },
      {
        name: 'memo',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'enable',
      },
      {
        name: 'salschemename',
      },
      {
        name: 'updateman',
      },
      {
        name: 'salscheme',
        prop: 'salschemeid',
      },
      {
        name: 'validflag',
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