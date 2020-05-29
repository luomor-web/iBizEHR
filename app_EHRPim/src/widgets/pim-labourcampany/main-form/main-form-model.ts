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
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimlabourcampanyid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimlabourcampanyname',
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
        name: 'pimlabourcampanyname',
        prop: 'pimlabourcampanyname',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'lxdz',
        prop: 'lxdz',
        dataType: 'TEXT',
      },
      {
        name: 'lxr',
        prop: 'lxr',
        dataType: 'TEXT',
      },
      {
        name: 'lxfs',
        prop: 'lxfs',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'legalperosn',
        prop: 'legalperosn',
        dataType: 'TEXT',
      },
      {
        name: 'regcapital',
        prop: 'regcapital',
        dataType: 'TEXT',
      },
      {
        name: 'gsjj',
        prop: 'gsjj',
        dataType: 'TEXT',
      },
      {
        name: 'pimlabourcampanyid',
        prop: 'pimlabourcampanyid',
        dataType: 'GUID',
      },
      {
        name: 'pimlabourcampany',
        prop: 'pimlabourcampanyid',
        dataType: 'FONTKEY',
      },
    ]
  }

}