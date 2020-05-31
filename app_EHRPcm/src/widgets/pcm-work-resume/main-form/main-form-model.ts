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
        prop: 'pcmworkresumeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmworkresumename',
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
        name: 'pcmprofileid',
        prop: 'pcmprofileid',
        dataType: 'PICKUP',
      },
      {
        name: 'servebegintime',
        prop: 'servebegintime',
        dataType: 'DATE',
      },
      {
        name: 'serveendtime',
        prop: 'serveendtime',
        dataType: 'DATE',
      },
      {
        name: 'workunit',
        prop: 'workunit',
        dataType: 'TEXT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'TEXT',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'TEXT',
      },
      {
        name: 'gw',
        prop: 'gw',
        dataType: 'TEXT',
      },
      {
        name: 'resumecontent',
        prop: 'resumecontent',
        dataType: 'TEXT',
      },
      {
        name: 'pcmworkresumeid',
        prop: 'pcmworkresumeid',
        dataType: 'GUID',
      },
      {
        name: 'pcmworkresume',
        prop: 'pcmworkresumeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}