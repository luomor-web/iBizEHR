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
        name: 'enable',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'seialno',
      },
      {
        name: 'pimqualtype',
        prop: 'pimqualtypeid',
      },
      {
        name: 'createdate',
      },
      {
        name: 'pimqualtypename',
      },
    ]
  }


}