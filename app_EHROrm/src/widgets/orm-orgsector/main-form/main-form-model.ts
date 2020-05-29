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
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'orgsectorname',
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
        name: 'ordervalue',
        prop: 'ordervalue',
        dataType: 'INT',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'shortname',
        prop: 'shortname',
        dataType: 'TEXT',
      },
      {
        name: 'bmlx',
        prop: 'bmlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'qy',
        prop: 'qy',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bmbzrs',
        prop: 'bmbzrs',
        dataType: 'INT',
      },
      {
        name: 'gkjz',
        prop: 'gkjz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'validflag',
        prop: 'validflag',
        dataType: 'YESNO',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsector',
        prop: 'orgsectorid',
        dataType: 'FONTKEY',
      },
    ]
  }

}