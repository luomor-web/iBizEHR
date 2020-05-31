/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATE',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimenclosureid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimenclosurename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimenclosurename',
        prop: 'pimenclosurename',
        dataType: 'TEXT',
      },
      {
        name: 'fjfl',
        prop: 'fjfl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fjkz',
        prop: 'fjkz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimenclosureid',
        prop: 'pimenclosureid',
        dataType: 'GUID',
      },
      {
        name: 'pimenclosure',
        prop: 'pimenclosureid',
        dataType: 'FONTKEY',
      },
    ]
  }

}