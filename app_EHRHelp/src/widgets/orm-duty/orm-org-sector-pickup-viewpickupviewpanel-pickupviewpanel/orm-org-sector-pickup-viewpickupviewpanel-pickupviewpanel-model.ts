/**
 * OrmOrgSectorPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class OrmOrgSectorPickupViewpickupviewpanelModel
 */
export default class OrmOrgSectorPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof OrmOrgSectorPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'ormduty',
        prop: 'ormdutyid',
      },
      {
        name: 'fglx',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'xh',
      },
      {
        name: 'createman',
      },
      {
        name: 'zwjb',
      },
      {
        name: 'createdate',
      },
      {
        name: 'dyzj',
      },
      {
        name: 'nx',
      },
      {
        name: 'zwlb',
      },
      {
        name: 'bxjlnx',
      },
      {
        name: 'ormdutyname',
      },
    ]
  }


}