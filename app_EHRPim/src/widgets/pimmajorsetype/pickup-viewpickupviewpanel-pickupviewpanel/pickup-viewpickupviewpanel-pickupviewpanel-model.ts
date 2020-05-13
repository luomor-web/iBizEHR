/**
 * PickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PickupViewpickupviewpanelModel
 */
export default class PickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'updatedate',
      },
      {
        name: 'pimmajorsetype',
        prop: 'pimmajorsetypeid',
      },
      {
        name: 'createdate',
      },
      {
        name: 'serialno',
      },
      {
        name: 'pimmajorsetypename',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createman',
      },
    ]
  }


}