/**
 * Main_CALLOUT 部件模型
 *
 * @export
 * @class Main_CALLOUTModel
 */
export default class Main_CALLOUTModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_CALLOUTModel
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
        prop: 'pimarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'operations',
        prop: 'operations',
        dataType: 'SSCODELIST',
      },
      {
        name: 'operationdate',
        prop: 'operationdate',
        dataType: 'DATE',
      },
      {
        name: 'ormorgid2',
        prop: 'ormorgid2',
        dataType: 'PICKUP',
      },
      {
        name: 'dabh',
        prop: 'dabh',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgid3',
        prop: 'ormorgid3',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname3',
        prop: 'ormorgname3',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'dabgdd',
        prop: 'dabgdd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dabgd',
        prop: 'dabgd',
        dataType: 'TEXT',
      },
      {
        name: 'dalyd',
        prop: 'dalyd',
        dataType: 'TEXT',
      },
      {
        name: 'archivescentername',
        prop: 'archivescentername',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimarchivesid',
        prop: 'pimarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'archivescenterid',
        prop: 'archivescenterid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchives',
        prop: 'pimarchivesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}