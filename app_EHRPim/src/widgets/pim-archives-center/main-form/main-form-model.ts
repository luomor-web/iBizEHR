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
        prop: 'archivescenterid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'position',
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
        name: 'serialno',
        prop: 'serialno',
        dataType: 'INT',
      },
      {
        name: 'layerno',
        prop: 'layerno',
        dataType: 'SSCODELIST',
      },
      {
        name: 'archivescentername',
        prop: 'archivescentername',
        dataType: 'TEXT',
      },
      {
        name: 'cabinetno',
        prop: 'cabinetno',
        dataType: 'TEXT',
      },
      {
        name: 'bnumber',
        prop: 'bnumber',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'archivescenterid',
        prop: 'archivescenterid',
        dataType: 'GUID',
      },
      {
        name: 'pimarchivescenter',
        prop: 'archivescenterid',
        dataType: 'FONTKEY',
      },
    ]
  }

}