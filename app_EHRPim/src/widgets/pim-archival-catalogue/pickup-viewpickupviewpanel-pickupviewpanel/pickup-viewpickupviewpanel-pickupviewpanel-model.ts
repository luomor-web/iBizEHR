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
        name: 'serialnumber',
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
        name: 'createman',
      },
      {
        name: 'updateman',
      },
      {
        name: 'pimarchivalcatalogue',
        prop: 'archivalcatalogueid',
      },
      {
        name: 'archivalcataloguename',
      },
      {
        name: 'pimarchivesname',
      },
      {
        name: 'pimarchivesid',
      },
    ]
  }


}