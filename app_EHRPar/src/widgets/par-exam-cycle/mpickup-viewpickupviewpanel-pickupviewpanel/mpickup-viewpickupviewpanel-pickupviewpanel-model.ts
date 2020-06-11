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
        name: 'parexamcycle',
        prop: 'parexamcycleid',
      },
      {
        name: 'createman',
      },
      {
        name: 'parexamcyclename',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'cycleid',
      },
    ]
  }


}